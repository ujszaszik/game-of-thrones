package hu.ujszaszik.data.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIME_OUT = 10_000 //ms

    @Provides
    @Singleton
    fun provideHttpClient(
        kotlinxSerializer: KotlinxSerializer,
        httpLogger: Logger,
    ): HttpClient {
        return HttpClient(Android) {

            install(JsonFeature) {
                serializer = kotlinxSerializer

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }
            }

            install(Logging) {
                logger = httpLogger
                level = LogLevel.ALL
            }
        }
    }

    @Provides
    @Singleton
    fun provideSerializer(): KotlinxSerializer {
        return KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    @Provides
    @Singleton
    fun provideHttpLogger(): Logger {
        return object : Logger {
            override fun log(message: String) {
                Log.v("KTOR HTTP :: =>", message)
            }
        }
    }

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun provideNetworkRequest(): NetworkRequest = NetworkRequest.Builder().build()
}