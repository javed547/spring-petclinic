package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class PetTest {
	@InjectMocks
	private Pet pet;

	@Mock
	private LocalDate localDateMock;

	@Mock
	private PetType petTypeMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.setBirthDate

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setBirthDate(java.time.LocalDate)

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#setBirthDate(LocalDate)}
	 */
	@Test
	@DisplayName("setBirthDate: ")
	public void testSetBirthDate() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		pet.setBirthDate(null);

		LocalDate finalPetBirthDate = ((LocalDate) getFieldValue(pet, "org.springframework.samples.petclinic.owner.Pet", "birthDate"));

		assertNull(finalPetBirthDate);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.getBirthDate

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getBirthDate()

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#getBirthDate()}
	 * @utbot.returnsFrom {@code return this.birthDate;}
	 */
	@Test
	@DisplayName("getBirthDate: -> return this.birthDate")
	public void testGetBirthDate_ReturnThisBirthDate() {
		LocalDate actual = pet.getBirthDate();

		assertSame(localDateMock, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.getType

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getType()

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#getType()}
	 * @utbot.returnsFrom {@code return this.type;}
	 */
	@Test
	@DisplayName("getType: -> return this.type")
	public void testGetType_ReturnThisType() {
		PetType actual = pet.getType();

		assertSame(petTypeMock, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.setType

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setType(org.springframework.samples.petclinic.owner.PetType)

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#setType(PetType)}
	 */
	@Test
	@DisplayName("setType: ")
	public void testSetType() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		pet.setType(null);

		PetType finalPetType = ((PetType) getFieldValue(pet, "org.springframework.samples.petclinic.owner.Pet", "type"));

		assertNull(finalPetType);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.getVisits

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getVisits()

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#getVisits()}
	 * @utbot.returnsFrom {@code return this.visits;}
	 */
	@Test
	@DisplayName("getVisits: -> return this.visits")
	public void testGetVisits_ReturnThisVisits() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		setField(pet, "org.springframework.samples.petclinic.owner.Pet", "visits", linkedHashSet);

		LinkedHashSet actual = ((LinkedHashSet) pet.getVisits());

		assertTrue(deepEquals(linkedHashSet, actual));
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Pet.addVisit

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method addVisit(org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#addVisit(Visit)}
	 * @utbot.invokes {@link Pet#getVisits()}
	 * @utbot.invokes {@link java.util.Collection#add(Object)}
	 */
	@Test
	@DisplayName("addVisit: PetGetVisits -> CollectionAdd")
	public void testAddVisit_CollectionAdd() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		setField(pet, "org.springframework.samples.petclinic.owner.Pet", "visits", linkedHashSet);

		pet.addVisit(null);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method addVisit(org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#addVisit(Visit)}
	 */
	@Test
	@DisplayName("addVisit: visit = mock() -> throw UnsupportedOperationException")
	public void testAddVisitThrowsUOE() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		pet.setName("");
		pet.setId(1);
		Set set = emptySet();
		setField(pet, "org.springframework.samples.petclinic.owner.Pet", "visits", set);
		Visit visitMock = mock(Visit.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Pet.addVisit] produces [java.lang.UnsupportedOperationException]
            java.base/java.util.AbstractCollection.add(AbstractCollection.java:251)
            org.springframework.samples.petclinic.owner.Pet.addVisit(Pet.java:82) */
		pet.addVisit(visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Pet}
	 * @utbot.methodUnderTest {@link Pet#addVisit(Visit)}
	 */
	@Test
	@DisplayName("addVisit: visit = mock() -> throw NullPointerException")
	public void testAddVisitThrowsNPE() {
		Visit visitMock = mock(Visit.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Pet.addVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Pet.addVisit(Pet.java:82) */
		pet.addVisit(visitMock);
	}
	///endregion

	///endregion


	@BeforeEach
	public void setUp() {
		mockitoCloseable = openMocks(this);
	}

	@AfterEach
	public void tearDown() throws Exception {
		mockitoCloseable.close();
	}

}
