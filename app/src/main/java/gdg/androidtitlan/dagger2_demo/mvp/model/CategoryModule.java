/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gdg.androidtitlan.dagger2_demo.mvp.model;

import dagger.Module;
import dagger.Provides;
import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;
import gdg.androidtitlan.dagger2_demo.mvp.presenter.CategoryPresenter;
import gdg.androidtitlan.dagger2_demo.mvp.presenter.impl.CategoryPresenterImpl;
import gdg.androidtitlan.dagger2_demo.mvp.ui.CategoryView;

@Module public class CategoryModule {

  private CategoryView view;

  public CategoryModule(CategoryView view) {
    this.view = view;
  }

  @Provides public CategoryView provideView() {
    return view;
  }

  @Provides public CategoryPresenter providePresenter(CategoryView categoryView,
      CategoryInteractor categoryInteractor) {
    return new CategoryPresenterImpl(categoryView, categoryInteractor);
  }
}
