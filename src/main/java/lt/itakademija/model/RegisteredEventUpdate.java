package lt.itakademija.model;

public final class RegisteredEventUpdate {

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
