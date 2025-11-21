package fr.everydaysapps.marvelsuperheroes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.everydaysapps.marvelsuperheroes.api.HeroApi
import fr.everydaysapps.marvelsuperheroes.data.HeroesRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        private const val BASE_URL = "http://coemygroup.fr/"
    }

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory): HeroApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .build()
        return retrofit.create(HeroApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideHeroesRepository(api: HeroApi): HeroesRepository {
        return HeroesRepository(api)
    }
}
