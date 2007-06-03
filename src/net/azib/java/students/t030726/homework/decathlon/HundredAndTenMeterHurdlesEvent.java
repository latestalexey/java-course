package decathlon;

/**
 * A representation of the 110m hurdles run. Has all relevant constants defined, that are relevant for the computation formula.
 * @author Deniss Nikiforov
 *
 */
public class HundredAndTenMeterHurdlesEvent extends RunnerDecathlonEvent {
	private final static double aParameter = 5.74352;
	private final static double bParameter = 28.5;
	private final static double cParameter = 1.92;
	private final static double handTime = 0.24;

	public HundredAndTenMeterHurdlesEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}

}
