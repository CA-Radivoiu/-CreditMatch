package com.example.creditmatch.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.creditmatch.application.creditform.data.BankRepository
import com.example.creditmatch.application.creditform.data.UserRepository
import com.example.creditmatch.dal.AppDatabase
import com.example.creditmatch.dal.dao.AccountDao
import com.example.creditmatch.dal.dao.UserDao
import com.example.creditmatch.dal.repository.BankRepositoryImpl
import com.example.creditmatch.dal.repository.UserRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            //.registerTypeHierarchyAdapter(Map::class.java, MapJsonSerializer())
            .create()
    }

    @Singleton
    @Provides
    fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return logger
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(logger: HttpLoggingInterceptor): OkHttpClient.Builder {

        val trustManager = object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                chain: Array<X509Certificate?>?,
                authType: String?
            ) = Unit

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                chain: Array<X509Certificate?>?,
                authType: String?
            ) = Unit

            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        }

        val trustAllCerts: Array<TrustManager> = arrayOf(trustManager)
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, null)
        val sslSocketFactory = sslContext.socketFactory
        return OkHttpClient
            .Builder()
            .addInterceptor(logger)
            .sslSocketFactory(sslSocketFactory, trustManager)
            .hostnameVerifier(HostnameVerifier { hostname, session -> true })
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson, okHttpBuilder: OkHttpClient.Builder): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpBuilder.build())
           // .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }




    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao

    @Singleton
    @Provides
    fun provideAccountDao(db: AppDatabase): AccountDao = db.accountDao


}