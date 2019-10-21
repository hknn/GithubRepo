package com.github.app.di


import com.atech.daggerexample.di.module.AppModule
import com.github.app.BaseApplication
import com.github.app.di.module.GeneralModule
import com.github.app.di.module.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        GeneralModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    override fun inject(instance: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: BaseApplication): Builder

        fun build(): AppComponent
    }
}