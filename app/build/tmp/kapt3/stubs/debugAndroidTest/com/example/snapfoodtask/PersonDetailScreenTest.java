package com.example.snapfoodtask;

import androidx.compose.ui.test.*;
import androidx.compose.runtime.Composable;
import androidx.compose.material.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.test.junit4.ComposeTestRule;
import com.example.snapfoodtask.viewmodel.PersonViewModel;
import com.example.snapfoodtask.model.Person;
import com.example.snapfoodtask.model.PersonDetail;
import com.example.snapfoodtask.model.PlanetDetail;
import kotlinx.coroutines.flow.StateFlow;
import org.junit.Rule;
import org.junit.Test;
import io.mockk.*;
import androidx.compose.ui.test.*;
import androidx.compose.material.*;
import androidx.compose.foundation.layout.*;
import io.mockk.*;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.junit.Before;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\f\u0010\u000e\u001a\u00060\nj\u0002`\u000fH\u0007R\u0013\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/snapfoodtask/PersonDetailScreenTest;", "", "()V", "composeTestRule", "Landroidx/compose/ui/test/junit4/ComposeContentTestRule;", "getComposeTestRule", "()Landroidx/compose/ui/test/junit4/ComposeContentTestRule;", "mockViewModel", "Lcom/example/snapfoodtask/viewmodel/PersonViewModel;", "ErrorScreen", "", "message", "", "setup", "testPersonDetailScreenDisplaysPersonInfo", "Lkotlinx/coroutines/test/TestResult;", "app_debugAndroidTest"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class PersonDetailScreenTest {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.test.junit4.ComposeContentTestRule composeTestRule = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.snapfoodtask.viewmodel.PersonViewModel mockViewModel = null;
    
    public PersonDetailScreenTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.test.junit4.ComposeContentTestRule getComposeTestRule() {
        return null;
    }
    
    @org.junit.Before()
    public final void setup() {
    }
    
    @org.junit.Test()
    public final void testPersonDetailScreenDisplaysPersonInfo() {
    }
    
    @androidx.compose.runtime.Composable()
    public final void ErrorScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}