package lt.itakademija.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public final class RegisteredEventUpdate {

    @NotNull
    private SeverityLevel severityLevel;


    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public String toString() {
        return "ChangeEventSeverityLevel [severityLevel=" + severityLevel + "]";
    }

}
