package com.example.snapfoodtask.repository;

import com.example.snapfoodtask.network.SWAPIService;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/snapfoodtask/repository/SWAPIRepository;", "", "swapiService", "Lcom/example/snapfoodtask/network/SWAPIService;", "(Lcom/example/snapfoodtask/network/SWAPIService;)V", "getPeople", "Lcom/example/snapfoodtask/model/PeopleResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonPlanets", "Lcom/example/snapfoodtask/model/PlanetDetail;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonSpecies", "Lcom/example/snapfoodtask/model/PersonDetail;", "searchPerson", "query", "", "page", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SWAPIRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.snapfoodtask.network.SWAPIService swapiService = null;
    
    @javax.inject.Inject()
    public SWAPIRepository(@org.jetbrains.annotations.NotNull()
    com.example.snapfoodtask.network.SWAPIService swapiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPeople(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PeopleResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPersonSpecies(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PersonDetail> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPersonPlanets(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PlanetDetail> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchPerson(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.snapfoodtask.model.PeopleResponse> $completion) {
        return null;
    }
}