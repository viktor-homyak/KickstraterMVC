package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.LocationManager;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.MainPageView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageControllerTest {

    @Mock
    private MainPageModel model;

    @Mock
    private MainPageView view;

    @Mock
    private LocationManager locationManager;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }


    @Test()
    public void onApplicationStartRenderMainPage() throws Exception {
        int[] path = new int[]{0, 0};
        MainPageController controller = new MainPageController(view, model);
        controller.setLocationManager(locationManager);

        when(view.getInput()).thenReturn("1");
        locationManager.setPath(path);

        controller.start(path);

        verify(view, times(1)).render(model);
        verify(locationManager, times(1)).dispatch();
    }
}
