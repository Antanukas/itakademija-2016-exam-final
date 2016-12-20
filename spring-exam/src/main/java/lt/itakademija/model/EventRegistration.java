package lt.itakademija.model;

import java.util.Objects;

public final class EventRegistration {

    private SeverityLevel severityLevel;

    private String location;

    private String description;

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventRegistration that = (EventRegistration) o;
        return severityLevel == that.severityLevel &&
                Objects.equals(location, that.location) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severityLevel, location, description);
    }

    @Override
    public String toString() {
        return "EventRegistration [severityLevel=" + severityLevel + ", location=" + location + ", description="
                + description + "]";
    }

}
