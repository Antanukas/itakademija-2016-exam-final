package lt.itakademija.model;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

public final class RegisteredEventUpdate {

	@NotNull
    private SeverityLevel severityLevel;

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    @Required
    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public String toString() {
        return "ChangeEventSeverityLevel [severityLevel=" + severityLevel + "]";
    }

}
