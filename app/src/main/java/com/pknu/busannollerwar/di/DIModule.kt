package com.pknu.busannollerwar.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.pknu.busannollerwar.data.NetworkApi
import com.pknu.busannollerwar.data.datasource.article.ArticleDataSource
import com.pknu.busannollerwar.data.datasource.article.ArticleDataSourceImpl
import com.pknu.busannollerwar.data.datasource.comment.CommentDataSource
import com.pknu.busannollerwar.data.datasource.comment.CommentDataSourceImpl
import com.pknu.busannollerwar.data.datasource.user.UserDataSource
import com.pknu.busannollerwar.data.datasource.user.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DIModule {
    private val BASE_URL = ""

    @Provides
    @Singleton
    fun providesNetworkApi(): NetworkApi = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
        .create(NetworkApi::class.java)

    @Provides
    @Singleton
    fun providesArticleDataSource(networkApi: NetworkApi): ArticleDataSource =
        ArticleDataSourceImpl(networkApi)

    @Provides
    @Singleton
    fun providesUserDataSource(networkApi: NetworkApi): UserDataSource =
        UserDataSourceImpl(networkApi)

    @Provides
    @Singleton
    fun providesCommentDataSource(networkApi: NetworkApi): CommentDataSource =
        CommentDataSourceImpl(networkApi)
}