package hu.ujszaszik.gameofthrones.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hu.ujszaszik.data.remote.NetworkMonitor
import javax.inject.Inject

@HiltAndroidApp
class GameOfThronesApp : Application() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate() {
        super.onCreate()
        networkMonitor.registerNetworkCallback()
    }

}