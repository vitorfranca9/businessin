package br.com.ative.businessin.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class JSFPhaseListener implements PhaseListener {
	private static final long serialVersionUID = 5297399957108717398L;

	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.println(e.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		System.out.println(e.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
