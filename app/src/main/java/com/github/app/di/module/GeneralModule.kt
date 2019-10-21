package  com.github.app.di.module

import com.github.app.ui.RepoListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GeneralModule {

    @ContributesAndroidInjector
    abstract fun contributeViewHomeActivity(): RepoListActivity

}