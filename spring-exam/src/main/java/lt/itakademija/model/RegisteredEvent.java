package lt.itakademija.model;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public final class RegisteredEvent {

	@NotNull
	private Long id;
	@NotNull
	private Date registrationDate;
	@NotNull
	private SeverityLevel severityLevel;
	@NotNull
	@Length(min = 1, max = 100)
	private String location;
	@NotNull
	@Length(min = 1, max = 1000)
	private String description;

	public RegisteredEvent() {
	}

	public RegisteredEvent(Long id, Date registrationDate, SeverityLevel severityLevel, String location,
			String description) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.severityLevel = severityLevel;
		this.location = location;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public SeverityLevel getSeverityLevel() {
		return severityLevel;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RegisteredEvent that = (RegisteredEvent) o;
		return Objects.equals(id, that.id) && Objects.equals(registrationDate, that.registrationDate)
				&& severityLevel == that.severityLevel && Objects.equals(location, that.location)
				&& Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, registrationDate, severityLevel, location, description);
	}

	@Override
	public String toString() {
		return "RegisteredEvent [id=" + id + ", registrationDate=" + registrationDate + ", severityLevel="
				+ severityLevel + ", location=" + location + ", description=" + description + "]";
	}

}
