package com.example.snapfoodtask.network;

import com.example.snapfoodtask.model.PeopleResponse;
import com.example.snapfoodtask.model.PersonDetail;
import com.example.snapfoodtask.model.PlanetDetail;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/snapfoodtask/network/SWAPIService;", "", "getPeople", "Lcom/example/snapfoodtask/model/PeopleResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonDetail", "Lcom/example/snapfoodtask/model/PersonDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonPlanets", "Lcom/example/snapfoodtask/model/PlanetDetail;", "getPersonSpecies", "searchPerson", "query", "", "page", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SWAPIService {
    
    @retrofit2.http.GET(value = "people/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPeople(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PeopleResponse> $completion);
    
    @retrofit2.http.GET(value = "people/{id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPersonDetail(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PersonDetail> $completion);
    
    @retrofit2.http.GET(value = "species/{id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPersonSpecies(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PersonDetail> $completion);
    
    @retrofit2.http.GET(value = "people/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchPerson(@retrofit2.http.Query(value = "search")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PeopleResponse> $completion);
    
    @retrofit2.http.GET(value = "planets/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPersonPlanets(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PlanetDetail> $completion);
}