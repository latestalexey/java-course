package net.azib.java.students.t093759.homework;

import java.util.*;

/**
 * Athlete class.
 *
 * @author dionis
 *         5/15/11 11:51 AM
 */
public class Athlete implements Cloneable, Comparable<Athlete> {
	private String name;
	private Calendar dateOfBirth;
	private String countryISO2LetterCode;
	private Double oneHundredMeterSprintInSeconds;
	private Double longJumpInMeters;
	private Double shotPutInMeters;
	private Double highJumpInMeters;
	private Double fourHundredMeterSprintInSeconds;
	private Double oneHundredTenMeterHurdlesInSeconds;
	private Double discusThrowInMeters;
	private Double poleVaultInMeters;
	private Double javelinThrowInMeter;
	private Double thousandFiveHundredMeterRaceInSeconds;

	private Athlete() {
	}

	public String getName() {
		return name;
	}

	/**
	 * You will get a cloned object of dateOfBirth.
	 *
	 * @return Cloned date of birth.
	 */
	public Calendar getDateOfBirth() {
		return (Calendar) dateOfBirth.clone();
	}

	public String getCountryISO2LetterCode() {
		return countryISO2LetterCode;
	}

	/**
	 * Get some results according to decathlon event.
	 *
	 * @param event Some decathlon event.
	 * @return result of one of decathlon event.
	 */
	public double get(DecathlonEvent event) {
		switch (event) {
			case DISCUS_THROW:
				return discusThrowInMeters;
			case FOUR_HUNDRED_METER_SPRINT:
				return fourHundredMeterSprintInSeconds;
			case HIGH_JUMP:
				return highJumpInMeters;
			case JAVELIN_THROW:
				return javelinThrowInMeter;
			case LONG_JUMP:
				return longJumpInMeters;
			case ONE_HUNDRED_METER_SPRINT:
				return oneHundredMeterSprintInSeconds;
			case ONE_HUNDRED_TEN_METER_HURDLES:
				return oneHundredTenMeterHurdlesInSeconds;
			case POLE_VAULT:
				return poleVaultInMeters;
			case SHOT_PUT:
				return shotPutInMeters;
			case THOUSAND_FIVE_HUNDRED_METER_SPRINT:
				return thousandFiveHundredMeterRaceInSeconds;
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	@SuppressWarnings({"RedundantIfStatement"})//Reason:I'm afraid to change generated code by intellij idea.
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Athlete athlete = (Athlete) o;

		if (!countryISO2LetterCode.equals(athlete.countryISO2LetterCode)) return false;
		if (!dateOfBirth.equals(athlete.dateOfBirth)) return false;
		if (!discusThrowInMeters.equals(athlete.discusThrowInMeters)) return false;
		if (!fourHundredMeterSprintInSeconds.equals(athlete.fourHundredMeterSprintInSeconds)) return false;
		if (!highJumpInMeters.equals(athlete.highJumpInMeters)) return false;
		if (!javelinThrowInMeter.equals(athlete.javelinThrowInMeter)) return false;
		if (!longJumpInMeters.equals(athlete.longJumpInMeters)) return false;
		if (!name.equals(athlete.name)) return false;
		if (!oneHundredMeterSprintInSeconds.equals(athlete.oneHundredMeterSprintInSeconds)) return false;
		if (!oneHundredTenMeterHurdlesInSeconds.equals(athlete.oneHundredTenMeterHurdlesInSeconds)) return false;
		if (!poleVaultInMeters.equals(athlete.poleVaultInMeters)) return false;
		if (!shotPutInMeters.equals(athlete.shotPutInMeters)) return false;
		if (!thousandFiveHundredMeterRaceInSeconds.equals(athlete.thousandFiveHundredMeterRaceInSeconds)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + dateOfBirth.hashCode();
		result = 31 * result + countryISO2LetterCode.hashCode();
		result = 31 * result + oneHundredMeterSprintInSeconds.hashCode();
		result = 31 * result + longJumpInMeters.hashCode();
		result = 31 * result + shotPutInMeters.hashCode();
		result = 31 * result + highJumpInMeters.hashCode();
		result = 31 * result + fourHundredMeterSprintInSeconds.hashCode();
		result = 31 * result + oneHundredTenMeterHurdlesInSeconds.hashCode();
		result = 31 * result + discusThrowInMeters.hashCode();
		result = 31 * result + poleVaultInMeters.hashCode();
		result = 31 * result + javelinThrowInMeter.hashCode();
		result = 31 * result + thousandFiveHundredMeterRaceInSeconds.hashCode();
		return result;
	}

	private boolean allFieldsAreNotNull() {
		return !(countryISO2LetterCode != null
				&& dateOfBirth != null && discusThrowInMeters != null
				&& fourHundredMeterSprintInSeconds != null && highJumpInMeters != null
				&& javelinThrowInMeter != null && longJumpInMeters != null
				&& name != null && oneHundredMeterSprintInSeconds != null
				&& oneHundredTenMeterHurdlesInSeconds != null && poleVaultInMeters != null
				&& shotPutInMeters != null && thousandFiveHundredMeterRaceInSeconds != null);
	}

	@Override
	public String toString() {
		return name + ", " + countryISO2LetterCode;
	}

	/**
	 * Compute points.
	 *
	 * @return computed points.
	 */
	public int computePoints() {
		int sum = 0;
		for (DecathlonEvent event : DecathlonEvent.values()) {
			double result = get(event);
			if (event.typeOfEvent() == DecathlonEvent.Type.JUMPING) result *= 100;//because we have results in meter,
			// but they should be measured in centimeters.
			sum += result;
		}
		return sum;
	}

	@Override
	public int compareTo(Athlete o) {
		if (this.computePoints() > o.computePoints()) return -1;
		else if (this.computePoints() < o.computePoints()) return 1;
		else return 0;
	}

	/**
	 * Builder will help you to create object of Athlete without worry that some fields are not initialized.
	 */
	public static class Builder {
		private static final Set<Character> ALLOWED_CHARACTERS = new HashSet<Character>(3);

		static {
			ALLOWED_CHARACTERS.add('(');
			ALLOWED_CHARACTERS.add(')');
			ALLOWED_CHARACTERS.add('-');
		}

		private Athlete athlete;

		public final static double ONE_DAY_IN_SECONDS = 24.0 * 60.0 * 60.0;

		public Builder(Athlete prototypeAthlete) throws CloneNotSupportedException {
			athlete = (Athlete) prototypeAthlete.clone();
		}

		public Builder() {
			athlete = new Athlete();
		}

		public Builder name(String name) {
			for (char c : name.toCharArray()) {
				if (!Character.isLetter(c) && !Character.isSpaceChar(c) && !ALLOWED_CHARACTERS.contains(c))
					throw new IllegalArgumentException("Name should consist only from characters, spaces and " + ALLOWED_CHARACTERS + ".");
			}
			athlete.name = name;
			return this;
		}

		public Builder setDateOfBirth(Calendar dateOfBirth) {
			dateOfBirth = (Calendar) dateOfBirth.clone();

			Calendar oneHundredTwentyYearsAgo = Calendar.getInstance();
			oneHundredTwentyYearsAgo.add(Calendar.YEAR, -120);

			Calendar today = Calendar.getInstance();

			if (dateOfBirth.before(oneHundredTwentyYearsAgo) || dateOfBirth.after(today))
				throw new IllegalArgumentException("Date of birth should be between today - 120 years and today.");

			athlete.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder setCountryISO2LetterCode(String countryISO2LetterCode) {
			countryISO2LetterCode = countryISO2LetterCode.toUpperCase();
			if (!Arrays.asList(Locale.getISOCountries()).contains(countryISO2LetterCode))
				throw new IllegalArgumentException("It's not a country ISO2 letter code.");
			athlete.countryISO2LetterCode = countryISO2LetterCode;
			return this;
		}

		public Builder setFourHundredMeterSprintTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("400 meter sprint time length should be 0 or more seconds and less than 24 hours in seconds.");
			athlete.fourHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setOneHundredMeterSprintTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("100 meter sprint time length should be 0 or more seconds and less than 24 hours in seconds.");
			athlete.oneHundredMeterSprintInSeconds = timeInSeconds;
			return this;
		}

		public Builder setLongJumpLength(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 20.0)
				throw new IllegalArgumentException("Long jump should be 0 or more meters and less than 20 meters in length.");
			athlete.longJumpInMeters = lengthInMeter;
			return this;
		}

		public Builder setShotPutLength(double lengthInMeter) {
			if (lengthInMeter < 0.0 || lengthInMeter >= 40.0)
				throw new IllegalArgumentException("Shot put should be 0 or more meters and less than 20 meters in length.");
			athlete.shotPutInMeters = lengthInMeter;
			return this;
		}

		public Builder setOneHundredTenMeterHurdlesTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("110 m hurdles should be 0 or more seconds and less than 24 hours in seconds.");
			athlete.oneHundredTenMeterHurdlesInSeconds = timeInSeconds;
			return this;
		}

		public Builder setDiscusThrowLength(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 200.0)
				throw new IllegalArgumentException("Discus throw should be zero or more meter length and less than 200 meter length.");
			athlete.discusThrowInMeters = lengthInMeters;
			return this;
		}

		public Builder setPoleVaultHeight(double heightInMeters) {
			if (heightInMeters < 0.0 || heightInMeters >= 20.0)
				throw new IllegalArgumentException("Pole vault should be zero or more meter in height and less than 20 meter in height.");
			athlete.poleVaultInMeters = heightInMeters;
			return this;
		}

		public Builder setJavelinThrowLength(double lengthInMeters) {
			if (lengthInMeters < 0.0 || lengthInMeters >= 150.0)
				throw new IllegalArgumentException("Javelin throw should be zero or more meter length and less than 150 meter length.");
			athlete.javelinThrowInMeter = lengthInMeters;
			return this;
		}

		public Builder setThousandFiveHundredMeterRaceTime(double timeInSeconds) {
			if (timeInSeconds < 0.0 || timeInSeconds >= ONE_DAY_IN_SECONDS)
				throw new IllegalArgumentException("1500 m race time should be 0 or more seconds and less than 24 hours in seconds.");
			athlete.thousandFiveHundredMeterRaceInSeconds = timeInSeconds;
			return this;
		}

		public Builder setHighJumpHeight(double heightInMeters) {
			if (heightInMeters < 0.0 || heightInMeters >= 5.0)
				throw new IllegalArgumentException("High jump should be zero or more meter in height and less than 5 meter in height.");
			athlete.highJumpInMeters = heightInMeters;
			return this;
		}

		public Athlete build() throws CloneNotSupportedException {
			if (athlete.allFieldsAreNotNull())
				throw new IllegalStateException("All fields should be set.");

			return (Athlete) athlete.clone();
		}
	}
}