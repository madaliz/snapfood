// Generated by Dagger (https://dagger.dev).
package com.example.snapfoodtask.viewmodel;

import com.example.snapfoodtask.repository.SWAPIRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PersonViewModel_Factory implements Factory<PersonViewModel> {
  private final Provider<SWAPIRepository> repositoryProvider;

  public PersonViewModel_Factory(Provider<SWAPIRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PersonViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PersonViewModel_Factory create(Provider<SWAPIRepository> repositoryProvider) {
    return new PersonViewModel_Factory(repositoryProvider);
  }

  public static PersonViewModel newInstance(SWAPIRepository repository) {
    return new PersonViewModel(repository);
  }
}
