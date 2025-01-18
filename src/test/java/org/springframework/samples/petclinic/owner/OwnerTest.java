package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;
import org.mockito.MockedStatic;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class OwnerTest {
	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getAddress

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getAddress()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getAddress()}
	 * @utbot.returnsFrom {@code return this.address;}
	 */
	@Test
	@DisplayName("getAddress: -> return this.address")
	public void testGetAddress_ReturnThisAddress() {
		Owner owner = new Owner();
		String address = "";
		owner.setAddress(address);

		String actual = owner.getAddress();

		assertEquals(address, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.setAddress

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setAddress(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#setAddress(String)}
	 */
	@Test
	@DisplayName("setAddress: ")
	public void testSetAddress() {
		Owner owner = new Owner();
		String address = "";
		owner.setAddress(address);

		owner.setAddress(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getCity

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getCity()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getCity()}
	 * @utbot.returnsFrom {@code return this.city;}
	 */
	@Test
	@DisplayName("getCity: -> return this.city")
	public void testGetCity_ReturnThisCity() {
		Owner owner = new Owner();
		String city = "";
		owner.setCity(city);

		String actual = owner.getCity();

		assertEquals(city, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.setCity

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setCity(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#setCity(String)}
	 */
	@Test
	@DisplayName("setCity: ")
	public void testSetCity() {
		Owner owner = new Owner();
		String city = "";
		owner.setCity(city);

		owner.setCity(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getTelephone

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getTelephone()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getTelephone()}
	 * @utbot.returnsFrom {@code return this.telephone;}
	 */
	@Test
	@DisplayName("getTelephone: -> return this.telephone")
	public void testGetTelephone_ReturnThisTelephone() {
		Owner owner = new Owner();
		String telephone = "";
		owner.setTelephone(telephone);

		String actual = owner.getTelephone();

		assertEquals(telephone, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.setTelephone

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setTelephone(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#setTelephone(String)}
	 */
	@Test
	@DisplayName("setTelephone: ")
	public void testSetTelephone() {
		Owner owner = new Owner();
		String telephone = "";
		owner.setTelephone(telephone);

		owner.setTelephone(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getPets

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPets()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPets()}
	 * @utbot.returnsFrom {@code return this.pets;}
	 */
	@Test
	@DisplayName("getPets: -> return this.pets")
	public void testGetPets_ReturnThisPets() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		ArrayList actual = ((ArrayList) owner.getPets());

		assertTrue(deepEquals(pets, actual));
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.addPet

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method addPet(org.springframework.samples.petclinic.owner.Pet)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addPet(Pet)}
	 * @utbot.executesCondition {@code (pet.isNew()): False}
	 */
	@Test
	@DisplayName("addPet: -> pet.isNew() : False")
	public void testAddPet_NotPetIsNew() {
		Owner owner = new Owner();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);

		owner.addPet(petMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addPet(Pet)}
	 * @utbot.executesCondition {@code (pet.isNew()): True}
	 * @utbot.invokes {@link Owner#getPets()}
	 * @utbot.invokes {@link List#add(Object)}
	 */
	@Test
	@DisplayName("addPet: pet.isNew() : True -> ListAdd")
	public void testAddPet_PetIsNew() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);

		owner.addPet(petMock);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method addPet(org.springframework.samples.petclinic.owner.Pet)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addPet(Pet)}
	 * @utbot.invokes {@link Pet#isNew()}
	 * @utbot.throwsException {@link NullPointerException} when: pet.isNew()
	 */
	@Test
	@DisplayName("addPet: pet.isNew() -> ThrowNullPointerException")
	public void testAddPet_ThrowNullPointerException() {
		Owner owner = new Owner();

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.addPet(Owner.java:97) */
		owner.addPet(null);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method addPet(org.springframework.samples.petclinic.owner.Pet)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addPet(Pet)}
	 */
	@Test
	@DisplayName("addPet: pet = mock() -> throw UnsupportedOperationException")
	public void testAddPetThrowsUOE() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("10");
		owner.setCity("-3");
		owner.setTelephone("abc");
		owner.setAddress("");
		List pets = emptyList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("");
		owner.setId(Integer.MAX_VALUE);
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addPet] produces [java.lang.UnsupportedOperationException]
            java.base/java.util.AbstractList.add(AbstractList.java:153)
            java.base/java.util.AbstractList.add(AbstractList.java:111)
            org.springframework.samples.petclinic.owner.Owner.addPet(Owner.java:98) */
		owner.addPet(petMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addPet(Pet)}
	 */
	@Test
	@DisplayName("addPet: pet = mock() -> throw NullPointerException")
	public void testAddPetThrowsNPE() {
		Owner owner = new Owner();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.addPet(Owner.java:98) */
		owner.addPet(petMock);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getPet

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 * @utbot.invokes {@link Owner#getPet(String, boolean)}
	 * @utbot.returnsFrom {@code return getPet(name, false);}
	 */
	@Test
	@DisplayName("getPet: OwnerGetPet -> return getPet(name, false)")
	public void testGetPet_OwnerGetPet() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(((String) null));

		assertNull(actual);
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 */
	@Test
	@DisplayName("getPet: name = 'acb' -> return null")
	public void testGetPetWithNonEmptyString() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("");
		owner.setAddress("abc");
		owner.setTelephone("10");
		owner.setCity("");
		owner.setLastName("\n\t\r");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("-3");
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet("acb");

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 */
	@Test
	@DisplayName("getPet: name = '#$\\\"'' -> return null")
	public void testGetPetWithNonEmptyString1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("abc");
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("XZ");
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn("XZ");
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn("-3");
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("abc");
		owner.setFirstName("abc");
		owner.setId(-1);
		owner.setAddress("#$\\\"'");
		owner.setTelephone("-3");

		Pet actual = owner.getPet("#$\\\"'");

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 */
	@Test
	@DisplayName("getPet: name = '10'")
	public void testGetPetWithNonEmptyString2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("XZ");
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("10");
		pets.add(petMock1);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setAddress("10");
		owner.setCity("\n\t\r");
		owner.setFirstName("XZ");
		owner.setTelephone("XZ");
		owner.setLastName("XZ");

		Pet actual = owner.getPet("10");

		assertSame(petMock1, actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 */
	@Test
	@DisplayName("getPet: name = '\n\t\r' -> return null")
	public void testGetPetWithBlankString() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setId(Integer.MIN_VALUE);
		owner.setAddress("XZ");
		owner.setLastName("10");
		owner.setFirstName("");
		owner.setTelephone("10");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn(((String) null));
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn(((String) null));
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn(((String) null));
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn(((String) null));
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("-3");

		Pet actual = owner.getPet("\n\t\r");

		assertNull(actual);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method getPet(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String)}
	 */
	@Test
	@DisplayName("getPet: name = '' -> throw NullPointerException")
	public void testGetPetThrowsNPEWithEmptyString() {
		Owner owner = new Owner();

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:135)
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:108) */
		owner.getPet("");
	}
	///endregion

	///region OTHER: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String)

	@Test
	public void testGetPet1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn(((String) null));
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(((String) null));

		assertNull(actual);
	}

	@Test
	public void testGetPet2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "C\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
		(when(petMock.getName())).thenReturn(string);
		pets.add(petMock);
		Pet pet = ((Pet) createInstance("org.springframework.samples.petclinic.owner.Pet"));
		pets.add(pet);
		pets.add(pet);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(string);

		assertSame(petMock, actual);
	}
	///endregion

	///region OTHER: ERROR SUITE for method getPet(java.lang.String)

	@Test
	public void testGetPet3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "";
		(when(petMock.getName())).thenReturn(string);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:136)
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:108) */
		owner.getPet(((String) null));
	}

	@Test
	public void testGetPet4() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn(((String) null));
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		String name = "";

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:136)
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:108) */
		owner.getPet(name);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getPet

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPet(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.returnsFrom {@code return null;}
	 */
	@Test
	@DisplayName("getPet: -> return null")
	public void testGetPet_ReturnNull() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(((Integer) null));

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 * @utbot.returnsFrom {@code return null;}
	 */
	@Test
	@DisplayName("getPet: !pet.isNew() : False -> return null")
	public void testGetPet_PetIsNew() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(((Integer) null));

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 * @utbot.returnsFrom {@code return null;}
	 */
	@Test
	@DisplayName("getPet: compId.equals(id) : False -> return null")
	public void testGetPet_NotCompIdEquals() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		Integer integer = 255;
		(when(petMock.getId())).thenReturn(integer);
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Integer id = -256;

		Pet actual = owner.getPet(id);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 */
	@Test
	@DisplayName("getPet: compId.equals(id) : True -> return pet")
	public void testGetPet_CompIdEquals() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		Integer integer = -255;
		(when(petMock.getId())).thenReturn(integer);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Integer id = -255;

		Pet actual = owner.getPet(id);

		assertSame(petMock, actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method getPet(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 * @utbot.throwsException {@link NullPointerException} when: !pet.isNew()
	 */
	@Test
	@DisplayName("getPet: !pet.isNew() -> ThrowNullPointerException")
	public void testGetPet_ThrowNullPointerException_1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:118) */
		owner.getPet(((Integer) null));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 * @utbot.throwsException {@link NullPointerException} when: compId.equals(id)
	 */
	@Test
	@DisplayName("getPet: compId.equals(id) -> ThrowNullPointerException")
	public void testGetPet_ThrowNullPointerException() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(((Integer) null));
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:120) */
		owner.getPet(((Integer) null));
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getPet(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = zero (mutated from min) -> return null")
	public void testGetPetWithCornerCase() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setAddress("10");
		owner.setId(Integer.MIN_VALUE);
		owner.setCity("10");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(-1);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setTelephone("-3");
		owner.setFirstName("10");
		owner.setLastName("10");

		Pet actual = owner.getPet(0);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = 3 (mutated from positive) -> return null")
	public void testGetPet() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("#$\\\"'");
		owner.setCity("\n\t\r");
		owner.setTelephone("10");
		owner.setFirstName("\n\t\r");
		owner.setAddress("#$\\\"'");
		owner.setId(Integer.MAX_VALUE);
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MAX_VALUE);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(3);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = min (mutated from zero) -> return null")
	public void testGetPetWithCornerCase1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("-3");
		owner.setFirstName("\n\t\r");
		owner.setCity("\n\t\r");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(true);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.isNew())).thenReturn(false);
		(when(petMock4.getId())).thenReturn(0);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setTelephone("\n\t\r");
		owner.setId(Integer.MIN_VALUE);
		owner.setAddress("\n\t\r");

		Pet actual = owner.getPet(Integer.MIN_VALUE);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = min (mutated from zero)")
	public void testGetPetWithCornerCase2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("10");
		owner.setLastName("abc");
		owner.setTelephone("#$\\\"'");
		owner.setId(-1);
		owner.setAddress("");
		owner.setCity("abc");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock1);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(Integer.MIN_VALUE);

		assertSame(petMock1, actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = -1")
	public void testGetPet5() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setCity("abc");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(false);
		(when(petMock2.getId())).thenReturn(-1);
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setTelephone("\r\n\t");
		owner.setFirstName("-3");
		owner.setLastName("\n\t\r");
		owner.setAddress("\n\t\r");

		Pet actual = owner.getPet(-1);

		assertSame(petMock2, actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = zero (mutated from min)")
	public void testGetPetWithCornerCase3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("-3");
		owner.setFirstName("\n\t\r");
		owner.setCity("\n\t\r");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(true);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.isNew())).thenReturn(false);
		(when(petMock4.getId())).thenReturn(0);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setTelephone("\n\t\r");
		owner.setId(Integer.MIN_VALUE);
		owner.setAddress("\n\t\r");

		Pet actual = owner.getPet(0);

		assertSame(petMock4, actual);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method getPet(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = 2147482846 (mutated from 2147482878) -> throw NullPointerException")
	public void testGetPetThrowsNPE() {
		Owner owner = new Owner();

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:117) */
		owner.getPet(2147482846);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = -1 -> throw NullPointerException")
	public void testGetPetThrowsNPE1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(((Integer) null));
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:120) */
		owner.getPet(-1);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(Integer)}
	 */
	@Test
	@DisplayName("getPet: id = zero -> throw NullPointerException")
	public void testGetPetThrowsNPEWithCornerCase() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setAddress("-3");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(1);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(((Integer) null));
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("10");
		owner.setTelephone("#$\\\"'");
		owner.setFirstName("abc");
		owner.setId(-1);
		owner.setCity("");

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:120) */
		owner.getPet(0);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.getPet

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String, boolean)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 * @utbot.returnsFrom {@code return null;}
	 */
	@Test
	@DisplayName("getPet: -> return null")
	public void testGetPet_ReturnNull1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(null, false);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 */
	@Test
	@DisplayName("getPet: IteratorNext -> return pet")
	public void testGetPet_NotPetIsNew() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "";
		(when(petMock.getName())).thenReturn(string);
		(when(petMock.isNew())).thenReturn(false);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(string, true);

		assertSame(petMock, actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method getPet(java.lang.String, boolean)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 * @utbot.invokes {@link Owner#getPets()}
	 * @utbot.invokes {@link List#iterator()}
	 * @utbot.iterates iterate the loop {@code for(Pet pet: getPets())} once
	 * @utbot.throwsException {@link NullPointerException} in: String compName = pet.getName();
	 */
	@Test
	@DisplayName("getPet: compName = pet.getName() : True -> ThrowNullPointerException")
	public void testGetPet_ThrowNullPointerException1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:136) */
		owner.getPet(null, false);
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String, boolean)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '#$\\\"'', ignoreNew = min (mutated from zero) -> return null")
	public void testGetPetWithNonEmptyString3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setTelephone("XZ");
		owner.setCity("\n\t\r");
		owner.setFirstName("10");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("XZ");
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setId(-1);
		owner.setLastName("abc");
		owner.setAddress("10");

		Pet actual = owner.getPet("#$\\\"'", true);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '', ignoreNew = min (mutated from zero) -> return null")
	public void testGetPetWithEmptyString() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("-3");
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("XZ");
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn("#$\\\"'");
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn("");
		(when(petMock3.isNew())).thenReturn(true);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.getName())).thenReturn("#$\\\"'");
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("#$\\\"'");
		owner.setFirstName("10");
		owner.setCity("abc");
		owner.setAddress("10");
		owner.setTelephone("10");
		owner.setId(Integer.MAX_VALUE);

		Pet actual = owner.getPet("", true);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '', ignoreNew = min (mutated from zero) -> return null")
	public void testGetPetWithEmptyString1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("10");
		owner.setLastName("10");
		owner.setCity("#$\\\"'");
		owner.setTelephone("\n\t\r");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("");
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("\n\t\r");
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn("10");
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn("\n\t\r");
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.getName())).thenReturn("abc");
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setId(Integer.MIN_VALUE);
		owner.setAddress("#$\\\"'");

		Pet actual = owner.getPet("", true);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = 'XZ', ignoreNew = zero (mutated from min)")
	public void testGetPetWithNonEmptyString4() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setCity("#$\\\"'");
		owner.setId(Integer.MAX_VALUE);
		owner.setAddress("-3");
		owner.setLastName("10\u0003");
		owner.setFirstName("#$\\\"'");
		owner.setTelephone("10");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("abc");
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("XZ");
		pets.add(petMock1);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet("XZ", false);

		assertSame(petMock1, actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '\t\r\n', ignoreNew = min -> return null")
	public void testGetPetWithBlankString1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setId(-1);
		owner.setAddress("XZ");
		owner.setLastName("10");
		owner.setFirstName("");
		owner.setTelephone("10");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn(((String) null));
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn(((String) null));
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn(((String) null));
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn(((String) null));
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("-3");

		Pet actual = owner.getPet("\t\r\n", true);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '#$\\\"'', ignoreNew = min (mutated from zero)")
	public void testGetPetWithNonEmptyString5() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("\n\t\r");
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("XZ");
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.getName())).thenReturn(((String) null));
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.getName())).thenReturn("");
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.getName())).thenReturn("#$\\\"'");
		(when(petMock4.isNew())).thenReturn(false);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet("#$\\\"'", true);

		assertSame(petMock4, actual);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method getPet(java.lang.String, boolean)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#getPet(String, boolean)}
	 */
	@Test
	@DisplayName("getPet: name = '', ignoreNew = min (mutated from zero) -> throw NullPointerException")
	public void testGetPetThrowsNPEWithEmptyString1() {
		Owner owner = new Owner();

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:135) */
		owner.getPet("", true);
	}
	///endregion

	///region OTHER: SUCCESSFUL EXECUTIONS for method getPet(java.lang.String, boolean)

	@Test
	public void testGetPet6() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "\u0000";
		(when(petMock.getName())).thenReturn(string);
		pets.add(petMock);
		pets.add(owner);
		pets.add(owner);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

		Pet actual = owner.getPet(string, false);

		assertSame(petMock, actual);
	}
	///endregion

	///region OTHER: ERROR SUITE for method getPet(java.lang.String, boolean)

	@Test
	public void testGetPet7() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "C\u0000";
		(when(petMock.getName())).thenReturn(string);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		String name = "\u0000\u0000";

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:136) */
		owner.getPet(name, false);
	}

	@Test
	public void testGetPet8() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		String string = "";
		(when(petMock.getName())).thenReturn(string);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.getPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:136) */
		owner.getPet(string, true);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.toString

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method toString()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.invokes {@link Owner#getId()}
	 * @utbot.invokes {@link Owner#isNew()}
	 * @utbot.invokes {@link Owner#getLastName()}
	 * @utbot.invokes {@link Owner#getFirstName()}
	 * @utbot.invokes {@link ToStringCreator#append(String, Object)}
	 * @utbot.invokes {@link ToStringCreator#append(String, Object)}
	 * @utbot.invokes {@link ToStringCreator#append(String, Object)}
	 * @utbot.invokes {@link ToStringCreator#toString()}
	 * @utbot.returnsFrom {@code return new ToStringCreator(this).append("id", this.getId()).append("new", this.isNew()).append("lastName", this.getLastName()).append("firstName", this.getFirstName()).append("address", this.address).append("city", this.city).append("telephone", this.telephone).toString();}
	 */
	@Test
	@DisplayName("toString: OwnerGetId -> return new ToStringCreator(this).append(\"id\", this.getId()).append(\"new\", this.isNew()).append(\"lastName\", this.getLastName()).append(\"firstName\", this.getFirstName()).append(\"address\", this.address).append(\"city\", this.city).append(\"telephone\", this.telephone).toString()")
	public void testToString_ToStringCreatorToString() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			ToStringCreator toStringCreatorMock2 = mock(ToStringCreator.class);
			(when(toStringCreatorMock2.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1);
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock2, toStringCreatorMock1, toStringCreatorMock1, toStringCreatorMock1);
			(when(toStringCreatorMock1.toString())).thenReturn(((String) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String address = "";
			owner.setAddress(address);
			owner.setCity(address);
			owner.setTelephone(address);
			owner.setFirstName(address);
			owner.setLastName(address);
			Integer id = 0;
			owner.setId(id);

			String actual = owner.toString();

			assertNull(actual);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method toString()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(null));
			Owner owner = new Owner();
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:149) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_1() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(((ToStringCreator) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String lastName = "";
			owner.setLastName(lastName);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:150) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_6() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(((ToStringCreator) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String firstName = "";
			owner.setFirstName(firstName);
			owner.setLastName(firstName);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:151) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_5() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			ToStringCreator toStringCreatorMock2 = mock(ToStringCreator.class);
			(when(toStringCreatorMock2.append(any(String.class), any(Object.class)))).thenReturn(((ToStringCreator) null));
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock2);
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String address = "";
			owner.setAddress(address);
			owner.setFirstName(address);
			owner.setLastName(address);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:152) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_2() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1, toStringCreatorMock1, ((ToStringCreator) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String address = "";
			owner.setAddress(address);
			owner.setCity(address);
			owner.setFirstName(address);
			owner.setLastName(address);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:153) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: append
	 */
	@Test
	@DisplayName("toString: append -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_3() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1, toStringCreatorMock1, toStringCreatorMock1, ((ToStringCreator) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String address = "";
			owner.setAddress(address);
			owner.setCity(address);
			owner.setTelephone(address);
			owner.setFirstName(address);
			owner.setLastName(address);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:154) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 * @utbot.invokes {@link ToStringCreator#toString()}
	 * @utbot.throwsException {@link NullPointerException} in: toString
	 */
	@Test
	@DisplayName("toString: toString -> ThrowNullPointerException")
	public void testToString_ThrowNullPointerException_4() {
		MockedConstruction mockedConstruction = null;
		try {
			ToStringCreator toStringCreatorMock1 = mock(ToStringCreator.class);
			(when(toStringCreatorMock1.append(any(String.class), anyBoolean()))).thenReturn(toStringCreatorMock1);
			ToStringCreator toStringCreatorMock2 = mock(ToStringCreator.class);
			(when(toStringCreatorMock2.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1);
			(when(toStringCreatorMock1.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock2, toStringCreatorMock1, toStringCreatorMock1, ((ToStringCreator) null));
			mockedConstruction = mockConstruction(ToStringCreator.class, (ToStringCreator toStringCreatorMock, Context context) -> (when(toStringCreatorMock.append(any(String.class), any(Object.class)))).thenReturn(toStringCreatorMock1));
			Owner owner = new Owner();
			String address = "";
			owner.setAddress(address);
			owner.setCity(address);
			owner.setTelephone(address);
			owner.setFirstName(address);
			owner.setLastName(address);
			Integer id = 0;
			owner.setId(id);

            /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.toString] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.Owner.toString(Owner.java:155) */
			owner.toString();
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method toString()

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 */
	@Test
	@DisplayName("toString: ")
	public void testToString() {
		Owner owner = new Owner();

		String actual = owner.toString();

		String expected = "[Owner@32177f8a id = 0, new = false, lastName = [null], firstName = [null], address = [null], city = [null], telephone = [null]]";

		assertEquals(expected, actual);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#toString()}
	 */
	@Test
	@DisplayName("toString: ")
	public void testToString1() {
		Owner owner = new Owner();

		String actual = owner.toString();

		String expected = "[Owner@77efa874 id = [null], new = true, lastName = [null], firstName = [null], address = [null], city = [null], telephone = [null]]";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Owner.addVisit

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method addVisit(java.lang.Integer, org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 * @utbot.invokes {@link Assert#notNull(Object, String)}
	 * @utbot.invokes {@link Assert#notNull(Object, String)}
	 * @utbot.invokes {@link Owner#getPet(Integer)}
	 * @utbot.invokes {@link Assert#notNull(Object, String)}
	 * @utbot.invokes {@link Pet#addVisit(Visit)}
	 */
	@Test
	@DisplayName("addVisit: AssertNotNull -> PetAddVisit")
	public void testAddVisit_PetAddVisit() throws Exception {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(Assert.class);
			Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
			ArrayList pets = new ArrayList();
			Pet petMock = mock(Pet.class);
			(when(petMock.isNew())).thenReturn(false);
			Integer integer = -255;
			(when(petMock.getId())).thenReturn(integer);
			(((Pet) (doNothing()).when(petMock))).addVisit(any());
			pets.add(petMock);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			pets.add(null);
			setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
			Integer petId = -255;

			owner.addVisit(petId, null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method addVisit(java.lang.Integer, org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 * @utbot.throwsException {@link NullPointerException} in: pet.addVisit(visit);
	 */
	@Test
	@DisplayName("addVisit: pet.addVisit(visit) : True -> ThrowNullPointerException")
	public void testAddVisit_ThrowNullPointerException() throws Exception {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(Assert.class);
			Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
			ArrayList pets = new ArrayList();
			setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

			/* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addVisit] produces [java.lang.NullPointerException] */
			owner.addVisit(null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 * @utbot.throwsException {@link NullPointerException} in: pet.addVisit(visit);
	 */
	@Test
	@DisplayName("addVisit: pet.addVisit(visit) : True -> ThrowNullPointerException")
	public void testAddVisit_ThrowNullPointerException_2() throws Exception {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(Assert.class);
			Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
			ArrayList pets = new ArrayList();
			Pet petMock = mock(Pet.class);
			(when(petMock.isNew())).thenReturn(true);
			pets.add(petMock);
			setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);

			/* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addVisit] produces [java.lang.NullPointerException] */
			owner.addVisit(null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 * @utbot.throwsException {@link NullPointerException} in: pet.addVisit(visit);
	 */
	@Test
	@DisplayName("addVisit: pet.addVisit(visit) : True -> ThrowNullPointerException")
	public void testAddVisit_ThrowNullPointerException_1() throws Exception {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(Assert.class);
			Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
			ArrayList pets = new ArrayList();
			Pet petMock = mock(Pet.class);
			(when(petMock.isNew())).thenReturn(false);
			Integer integer = 255;
			(when(petMock.getId())).thenReturn(integer);
			pets.add(petMock);
			setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
			Integer petId = -256;

			/* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addVisit] produces [java.lang.NullPointerException] */
			owner.addVisit(petId, null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method addVisit(java.lang.Integer, org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = min, visit = mock()")
	public void testAddVisitWithCornerCase() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setAddress("\n\t\r");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(Integer.MIN_VALUE);
		(((Pet) (doNothing()).when(petMock))).addVisit(any());
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("abc");
		owner.setCity("Pet identifier must not be null!");
		owner.setFirstName("XZ");
		owner.setId(Integer.MIN_VALUE);
		owner.setTelephone("XZ");
		Visit visitMock = mock(Visit.class);

		owner.addVisit(Integer.MIN_VALUE, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = positive (mutated from 129), visit = mock()")
	public void testAddVisit() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setCity("Pet identifier must not be null!");
		owner.setLastName("XZ");
		owner.setFirstName("10");
		owner.setId(Integer.MAX_VALUE);
		owner.setTelephone("Invalid Pet identifier!");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(0);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(1);
		(((Pet) (doNothing()).when(petMock1))).addVisit(any());
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setAddress("");
		Visit visitMock = mock(Visit.class);

		owner.addVisit(1, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = min, visit = mock()")
	public void testAddVisitWithCornerCase1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("Invalid Pet identifier!");
		owner.setLastName("\n\t\r");
		owner.setTelephone("");
		owner.setAddress("");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(0);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(false);
		(when(petMock2.getId())).thenReturn(Integer.MIN_VALUE);
		(((Pet) (doNothing()).when(petMock2))).addVisit(any());
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("abc");
		owner.setId(Integer.MAX_VALUE);
		Visit visitMock = mock(Visit.class);

		owner.addVisit(Integer.MIN_VALUE, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -1 (mutated from max), visit = mock()")
	public void testAddVisit1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setCity("Invalid Pet identifier!");
		owner.setAddress("Visit must not be null!");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(-1);
		(((Pet) (doNothing()).when(petMock1))).addVisit(any());
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		pets.add(petMock2);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("#$\\\"'");
		owner.setFirstName("XZ");
		owner.setTelephone("Pet identifier must not be null!");
		owner.setId(-1);
		Visit visitMock = mock(Visit.class);

		owner.addVisit(-1, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = positive, visit = mock()")
	public void testAddVisit2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("Pet identifier must not be null!");
		owner.setAddress("-3");
		owner.setId(Integer.MIN_VALUE);
		owner.setCity("XZ");
		owner.setFirstName("\n\t\r");
		owner.setTelephone("-3");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(0);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(1);
		(((Pet) (doNothing()).when(petMock3))).addVisit(any());
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Visit visitMock = mock(Visit.class);

		owner.addVisit(1, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = min, visit = mock()")
	public void testAddVisitWithCornerCase2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("XZ");
		owner.setFirstName("");
		owner.setAddress("10");
		owner.setCity("Pet identifier must not be null!");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(Integer.MIN_VALUE);
		(((Pet) (doNothing()).when(petMock3))).addVisit(any());
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setId(Integer.MAX_VALUE);
		owner.setTelephone("Visit must not be null!");
		Visit visitMock = mock(Visit.class);

		owner.addVisit(Integer.MIN_VALUE, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = min, visit = mock()")
	public void testAddVisitWithCornerCase3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setTelephone("\n\t\r");
		owner.setFirstName("");
		owner.setLastName("Pet identifier must not be null!");
		owner.setCity("XZ");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(false);
		(when(petMock2.getId())).thenReturn(Integer.MIN_VALUE);
		(((Pet) (doNothing()).when(petMock2))).addVisit(any());
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setId(1);
		owner.setAddress("XZ");
		Visit visitMock = mock(Visit.class);

		owner.addVisit(Integer.MIN_VALUE, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -1 (mutated from max), visit = mock()")
	public void testAddVisit3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setAddress("abc");
		owner.setTelephone("abc");
		owner.setLastName("10");
		owner.setCity("\n\t\r");
		owner.setFirstName("XZ");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(1);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(false);
		(when(petMock2.getId())).thenReturn(0);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.isNew())).thenReturn(false);
		(when(petMock4.getId())).thenReturn(-1);
		(((Pet) (doNothing()).when(petMock4))).addVisit(any());
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Visit visitMock = mock(Visit.class);

		owner.addVisit(-1, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = zero, visit = mock()")
	public void testAddVisitWithCornerCase4() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("Visit must not be null!");
		owner.setTelephone("");
		owner.setFirstName("Invalid Pet identifier!");
		owner.setId(65);
		owner.setAddress("#$\\\"'");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(Integer.MAX_VALUE);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(-1);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(true);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.isNew())).thenReturn(false);
		(when(petMock4.getId())).thenReturn(0);
		(((Pet) (doNothing()).when(petMock4))).addVisit(any());
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("abc");
		Visit visitMock = mock(Visit.class);

		owner.addVisit(0, visitMock);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method addVisit(java.lang.Integer, org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -2147483647 (mutated from positive), visit = mock() -> throw NullPointerException")
	public void testAddVisitThrowsNPE() {
		Owner owner = new Owner();
		Visit visitMock = mock(Visit.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:117)
            org.springframework.samples.petclinic.owner.Owner.addVisit(Owner.java:168) */
		owner.addVisit(-2147483647, visitMock);
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -1 (mutated from max), visit = mock() -> throw NullPointerException")
	public void testAddVisitThrowsNPE1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setId(-1);
		owner.setAddress("abc");
		owner.setLastName("-3");
		owner.setFirstName("10");
		owner.setTelephone("abc");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(((Integer) null));
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("-3");
		Visit visitMock = mock(Visit.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.Owner.addVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:120)
            org.springframework.samples.petclinic.owner.Owner.addVisit(Owner.java:168) */
		owner.addVisit(-1, visitMock);
	}
	///endregion

	///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method addVisit(java.lang.Integer, org.springframework.samples.petclinic.owner.Visit)

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -536870913 (mutated from -1), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		List pets = emptyList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setFirstName("-3");
		owner.setId(-1);
		owner.setTelephone("");
		owner.setAddress("-3");
		owner.setLastName("abc");
		owner.setCity("\n\t\r");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(-536870913, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -131073 (mutated from -1), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setId(Integer.MIN_VALUE);
		owner.setLastName("-3");
		owner.setCity("\n\t\r");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setFirstName("abc");
		owner.setAddress("");
		owner.setTelephone("");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(-131073, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = max, visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAEWithCornerCase() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setId(-1);
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(0);
		pets.add(petMock);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setAddress("abc");
		owner.setFirstName("Invalid Pet identifier!");
		owner.setCity("Invalid Pet identifier!");
		owner.setTelephone("10");
		owner.setLastName("10");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(Integer.MAX_VALUE, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -2147483647 (mutated from positive), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setTelephone("-3");
		owner.setId(1);
		owner.setFirstName("Invalid Pet identifier!");
		owner.setAddress("XZ");
		owner.setCity("10");
		LinkedList pets = new LinkedList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MAX_VALUE);
		pets.add(petMock1);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setLastName("\n\t\r");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(-2147483647, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = -2147221504 (mutated from min), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setFirstName("10");
		owner.setTelephone("Visit must not be null!");
		owner.setAddress("-3");
		owner.setLastName("\n\t\r");
		owner.setId(Integer.MIN_VALUE);
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(1);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(false);
		(when(petMock1.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(Integer.MAX_VALUE);
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setCity("-3");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(-2147221504, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = 33 (mutated from positive), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE4() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setLastName("Pet identifier must not be null!");
		owner.setAddress("-3");
		owner.setId(Integer.MIN_VALUE);
		owner.setCity("XZ");
		owner.setFirstName("\n\t\r");
		owner.setTelephone("-3");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		(when(petMock.getId())).thenReturn(0);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(true);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(1);
		pets.add(petMock3);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(33, visitMock));
	}

	/**
	 * @utbot.classUnderTest {@link Owner}
	 * @utbot.methodUnderTest {@link Owner#addVisit(Integer, Visit)}
	 */
	@Test
	@DisplayName("addVisit: petId = 8 (mutated from zero), visit = mock() -> throw IllegalArgumentException")
	public void testAddVisitThrowsIAE5() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		owner.setAddress("Visit must not be null!");
		owner.setFirstName("-3");
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.isNew())).thenReturn(true);
		pets.add(petMock1);
		Pet petMock2 = mock(Pet.class);
		(when(petMock2.isNew())).thenReturn(false);
		(when(petMock2.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock2);
		Pet petMock3 = mock(Pet.class);
		(when(petMock3.isNew())).thenReturn(false);
		(when(petMock3.getId())).thenReturn(Integer.MIN_VALUE);
		pets.add(petMock3);
		Pet petMock4 = mock(Pet.class);
		(when(petMock4.isNew())).thenReturn(true);
		pets.add(petMock4);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		owner.setTelephone("abc");
		owner.setLastName("");
		owner.setCity("-3");
		Visit visitMock = mock(Visit.class);

		assertThrows(IllegalArgumentException.class, () -> owner.addVisit(8, visitMock));
	}
	///endregion

	///endregion
}
