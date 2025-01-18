package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class VetTest {
	///region Test suites for executable org.springframework.samples.petclinic.vet.Vet.getSpecialtiesInternal

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getSpecialtiesInternal()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getSpecialtiesInternal()}
	 * @utbot.executesCondition {@code (this.specialties == null): False}
	 * @utbot.returnsFrom {@code return this.specialties;}
	 */
	@Test
	@DisplayName("getSpecialtiesInternal: this.specialties == null : False -> return this.specialties")
	public void testGetSpecialtiesInternal_ThisSpecialtiesNotEqualsNull() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		LinkedHashSet specialties = new LinkedHashSet();
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);

		LinkedHashSet actual = ((LinkedHashSet) vet.getSpecialtiesInternal());

		assertTrue(deepEquals(specialties, actual));
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getSpecialtiesInternal()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getSpecialtiesInternal()}
	 */
	@Test
	@DisplayName("getSpecialtiesInternal: ")
	public void testGetSpecialtiesInternal() {
		Vet vet = new Vet();

		HashSet actual = ((HashSet) vet.getSpecialtiesInternal());

		HashSet expected = new HashSet();

		assertTrue(deepEquals(expected, actual));
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.vet.Vet.getSpecialties

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getSpecialties()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getSpecialties()}
	 */
	@Test
	@DisplayName("getSpecialties: ")
	public void testGetSpecialties() {
		Vet vet = new Vet();

		List actual = vet.getSpecialties();

		List expected = new ArrayList();

		assertTrue(deepEquals(expected, actual));
	}

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getSpecialties()}
	 */
	@Test
	@DisplayName("getSpecialties: ")
	public void testGetSpecialties1() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		vet.setId(Integer.MIN_VALUE);
		vet.setLastName("10");
		vet.setFirstName("#$4\\\"'");
		Set specialties = emptySet();
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);

		List actual = vet.getSpecialties();

		List expected = new ArrayList();

		assertTrue(deepEquals(expected, actual));
	}
	///endregion

	///region FUZZER: SECURITY for method getSpecialties()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getSpecialties()}
	 */
	@Test
	@DisplayName("getSpecialties: ")
	@Disabled(value = "Disabled due to sandbox")
	public void testGetSpecialties2() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		vet.setLastName("\n\t\r");
		vet.setId(Integer.MAX_VALUE);
		HashSet specialties = new HashSet();
		Specialty specialtyMock = mock(Specialty.class);
		specialties.add(specialtyMock);
		Specialty specialtyMock1 = mock(Specialty.class);
		specialties.add(specialtyMock1);
		Specialty specialtyMock2 = mock(Specialty.class);
		specialties.add(specialtyMock2);
		Specialty specialtyMock3 = mock(Specialty.class);
		specialties.add(specialtyMock3);
		Specialty specialtyMock4 = mock(Specialty.class);
		specialties.add(specialtyMock4);
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);
		vet.setFirstName("abc");

		assertThrows(ExceptionInInitializerError.class, () -> vet.getSpecialties());
	}
	///endregion

	///region OTHER: ERROR SUITE for method getSpecialties()

	@Test
	public void testGetSpecialties3() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		LinkedHashSet specialties = new LinkedHashSet();
		Specialty specialtyMock = mock(Specialty.class);
		specialties.add(specialtyMock);
		Specialty specialtyMock1 = mock(Specialty.class);
		specialties.add(specialtyMock1);
		Specialty specialtyMock2 = mock(Specialty.class);
		specialties.add(specialtyMock2);
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);

		assertThrows(NoClassDefFoundError.class, () -> vet.getSpecialties());
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.vet.Vet.getNrOfSpecialties

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getNrOfSpecialties()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getNrOfSpecialties()}
	 * @utbot.invokes {@link Vet#getSpecialtiesInternal()}
	 * @utbot.invokes {@link Set#size()}
	 * @utbot.returnsFrom {@code return getSpecialtiesInternal().size();}
	 */
	@Test
	@DisplayName("getNrOfSpecialties: VetGetSpecialtiesInternal -> return getSpecialtiesInternal().size()")
	public void testGetNrOfSpecialties_SetSize() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		LinkedHashSet specialties = new LinkedHashSet();
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);

		int actual = vet.getNrOfSpecialties();

		assertEquals(0, actual);
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getNrOfSpecialties()

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#getNrOfSpecialties()}
	 */
	@Test
	@DisplayName("getNrOfSpecialties:  -> return 0")
	public void testGetNrOfSpecialtiesReturnsZero() {
		Vet vet = new Vet();

		int actual = vet.getNrOfSpecialties();

		assertEquals(0, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.vet.Vet.addSpecialty

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method addSpecialty(org.springframework.samples.petclinic.vet.Specialty)

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#addSpecialty(Specialty)}
	 * @utbot.invokes {@link Vet#getSpecialtiesInternal()}
	 * @utbot.invokes {@link Set#add(Object)}
	 */
	@Test
	@DisplayName("addSpecialty: VetGetSpecialtiesInternal -> SetAdd")
	public void testAddSpecialty_SetAdd() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		LinkedHashSet specialties = new LinkedHashSet();
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);

		vet.addSpecialty(null);
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method addSpecialty(org.springframework.samples.petclinic.vet.Specialty)

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#addSpecialty(Specialty)}
	 */
	@Test
	@DisplayName("addSpecialty: specialty = mock()")
	public void testAddSpecialty() {
		Vet vet = new Vet();
		Specialty specialtyMock = mock(Specialty.class);

		vet.addSpecialty(specialtyMock);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method addSpecialty(org.springframework.samples.petclinic.vet.Specialty)

	/**
	 * @utbot.classUnderTest {@link Vet}
	 * @utbot.methodUnderTest {@link Vet#addSpecialty(Specialty)}
	 */
	@Test
	@DisplayName("addSpecialty: specialty = mock() -> throw UnsupportedOperationException")
	public void testAddSpecialtyThrowsUOE() throws Exception {
		Vet vet = ((Vet) createInstance("org.springframework.samples.petclinic.vet.Vet"));
		Set specialties = emptySet();
		setField(vet, "org.springframework.samples.petclinic.vet.Vet", "specialties", specialties);
		vet.setId(-1048577);
		vet.setLastName("-3");
		vet.setFirstName("");
		Specialty specialtyMock = mock(Specialty.class);

        /* This test fails because method [org.springframework.samples.petclinic.vet.Vet.addSpecialty] produces [java.lang.UnsupportedOperationException]
            java.base/java.util.AbstractCollection.add(AbstractCollection.java:251)
            org.springframework.samples.petclinic.vet.Vet.addSpecialty(Vet.java:72) */
		vet.addSpecialty(specialtyMock);
	}
	///endregion

	///endregion
}
