package com.seannajera.golfiq.injection.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.seannajera.golfiq.injection.ViewModelKey
import com.seannajera.golfiq.viewmodel.GolfIqViewModelFactory
import com.seannajera.golfiq.viewmodel.UserModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap




@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserModel::class)
    internal abstract fun bindUserModel(userModel: UserModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: GolfIqViewModelFactory): ViewModelProvider.Factory
}
