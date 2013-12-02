package advanced.drawing;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.scaleProcessor.ScaleEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.zoomProcessor.ZoomEvent;


public class INF133ZoomAction implements IGestureEventListener{
	double start = 10000;
	double low=0;
	double high=0;
	double finish=0;

	public INF133ZoomAction (){}


	Float scale;

	public boolean processGestureEvent(MTGestureEvent g) {

		if (g instanceof ZoomEvent){
			ZoomEvent ze = (ZoomEvent) g;


			scale = ze.getCamZoomAmount();
			//scale = ze.getCamZoomAmount();

			if (start == 10000){
				start = scale.doubleValue();
			}

			else if (high < scale.doubleValue()){
				high = scale.doubleValue();
			}
			else if (low > scale.doubleValue())
			{
				low = scale.doubleValue();
			}

		}

		if (start < high){
			MainDrawingScene.setSlider(new Float (high)/30);
		}

		else if (start > low ){

			if (start < high){
				MainDrawingScene.setSlider(new Float (low)/30);
			}
		}


		if (g instanceof TapEvent){

		TapEvent te = (TapEvent) g;

		if (te.isDoubleTap()){
			MainDrawingScene.setSlider(0.05f);
		}
		}
		return false;
	}
}

