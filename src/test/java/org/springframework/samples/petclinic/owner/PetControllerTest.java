package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;
import org.mockito.MockedStatic;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class PetControllerTest {
	@InjectMocks
	private PetController petController;

	@Mock
	private OwnerRepository ownerRepositoryMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.populatePetTypes

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method populatePetTypes()

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#populatePetTypes()}
	 * @utbot.invokes {@link OwnerRepository#findPetTypes()}
	 * @utbot.returnsFrom {@code return this.owners.findPetTypes();}
	 */
	@Test
	@DisplayName("populatePetTypes: OwnerRepositoryFindPetTypes -> return this.owners.findPetTypes()")
	public void testPopulatePetTypes_OwnerRepositoryFindPetTypes() {
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(((List) null));

		Collection actual = petController.populatePetTypes();

		assertNull(actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.findOwner

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method findOwner(int)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findOwner(int)}
	 * @utbot.invokes {@link Optional#orElseThrow(java.util.function.Supplier)}
	 * @utbot.returnsFrom {@code return owner;}
	 */
	@Test
	@DisplayName("findOwner: IntegerValueOf -> OptionalOrElseThrow")
	public void testFindOwner_OptionalOrElseThrow() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

		Owner actual = petController.findOwner(-255);

		String actualAddress = actual.getAddress();
		assertNull(actualAddress);

		String actualCity = actual.getCity();
		assertNull(actualCity);

		String actualTelephone = actual.getTelephone();
		assertNull(actualTelephone);

		List ownerPets = owner.getPets();
		List actualPets = actual.getPets();
		assertTrue(deepEquals(ownerPets, actualPets));

		String actualFirstName = actual.getFirstName();
		assertNull(actualFirstName);

		String actualLastName = actual.getLastName();
		assertNull(actualLastName);

		Integer actualId = actual.getId();
		assertNull(actualId);

	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method findOwner(int)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findOwner(int)}
	 * @utbot.invokes {@link Optional#orElseThrow(java.util.function.Supplier)}
	 * @utbot.throwsException {@link ClassCastException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("findOwner: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowClassCastException")
	public void testFindOwner_ThrowClassCastException() {
		byte[] byteArray = {};
		Optional optional = of(byteArray);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findOwner] produces [java.lang.ClassCastException: class [B cannot be cast to class org.springframework.samples.petclinic.owner.Owner ([B is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @22f7455e)]
            org.springframework.samples.petclinic.owner.PetController.findOwner(PetController.java:63) */
		petController.findOwner(-255);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findOwner(int)}
	 * @utbot.throwsException {@link NullPointerException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("findOwner: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowNullPointerException")
	public void testFindOwner_ThrowNullPointerException() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findOwner] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.findOwner(PetController.java:63) */
		petController.findOwner(-255);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.findPet

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method findPet(int, java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 * @utbot.executesCondition {@code (petId == null): False}
	 * @utbot.invokes {@link Optional#orElseThrow(java.util.function.Supplier)}
	 * @utbot.invokes {@link Owner#getPet(Integer)}
	 * @utbot.returnsFrom {@code return owner.getPet(petId);}
	 */
	@Test
	@DisplayName("findPet: petId == null : False -> OptionalOrElseThrow")
	public void testFindPet_PetIdNotEqualsNull() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer petId = 0;

		Pet actual = petController.findPet(-252, petId);

		assertNull(actual);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 * @utbot.executesCondition {@code (petId == null): True}
	 * @utbot.returnsFrom {@code return new Pet();}
	 */
	@Test
	@DisplayName("findPet: petId == null : True -> return new Pet()")
	public void testFindPet_PetIdEqualsNull() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(Pet.class, (Pet petMock, Context context) -> {
			});

			Pet actual = petController.findPet(-255, null);

			Pet expectedMock = mock(Pet.class);

			assertSame(expectedMock, actual);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method findPet(int, java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 * @utbot.throwsException {@link IllegalArgumentException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("findPet: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowIllegalArgumentException")
	public void testFindPet_ThrowIllegalArgumentException() {
		Optional optional = empty();
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer petId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findPet] produces [java.lang.IllegalArgumentException: Owner not found with id: -255. Please ensure the ID is correct ]
            org.springframework.samples.petclinic.owner.PetController.lambda$findPet$1(PetController.java:77)
            java.base/java.util.Optional.orElseThrow(Optional.java:403)
            org.springframework.samples.petclinic.owner.PetController.findPet(PetController.java:77) */
		petController.findPet(-255, petId);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 * @utbot.throwsException {@link ClassCastException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("findPet: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowClassCastException")
	public void testFindPet_ThrowClassCastException() {
		short[] shortArray = {};
		Optional optional = of(shortArray);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer petId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findPet] produces [java.lang.ClassCastException: class [S cannot be cast to class org.springframework.samples.petclinic.owner.Owner ([S is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @22f7455e)]
            org.springframework.samples.petclinic.owner.PetController.findPet(PetController.java:77) */
		petController.findPet(-255, petId);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 * @utbot.throwsException {@link NullPointerException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("findPet: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowNullPointerException")
	public void testFindPet_ThrowNullPointerException() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));
		Integer petId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.findPet(PetController.java:77) */
		petController.findPet(-255, petId);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method findPet(int, java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#findPet(int, Integer)}
	 */
	@Test
	@DisplayName("findPet: ownerId = -16385 (mutated from -1), petId = -1 -> throw NullPointerException")
	public void testFindPetThrowsNPE() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		(when(optionalMock.orElseThrow(any()))).thenReturn(null);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.findPet] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.findPet(PetController.java:79) */
		petController.findPet(-16385, -1);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.initOwnerBinder

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initOwnerBinder(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initOwnerBinder(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 */
	@Test
	@DisplayName("initOwnerBinder: -> WebDataBinderSetDisallowedFields")
	public void testInitOwnerBinder_WebDataBinderSetDisallowedFields() {
		WebDataBinder dataBinderMock = mock(WebDataBinder.class);
		(((DataBinder) (doNothing()).when(dataBinderMock))).setDisallowedFields(any());

		petController.initOwnerBinder(dataBinderMock);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method initOwnerBinder(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initOwnerBinder(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 * @utbot.throwsException {@link NullPointerException} in: dataBinder.setDisallowedFields("id");
	 */
	@Test
	@DisplayName("initOwnerBinder: dataBinder.setDisallowedFields(\"id\") : True -> ThrowNullPointerException")
	public void testInitOwnerBinder_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.initOwnerBinder] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.initOwnerBinder(PetController.java:84) */
		petController.initOwnerBinder(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.initPetBinder

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initPetBinder(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initPetBinder(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setValidator(org.springframework.validation.Validator)}
	 */
	@Test
	@DisplayName("initPetBinder: -> WebDataBinderSetValidator")
	public void testInitPetBinder_WebDataBinderSetValidator() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(PetValidator.class, (PetValidator petValidatorMock, Context context) -> {
			});
			WebDataBinder dataBinderMock = mock(WebDataBinder.class);
			(((DataBinder) (doNothing()).when(dataBinderMock))).setValidator(any());

			petController.initPetBinder(dataBinderMock);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method initPetBinder(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initPetBinder(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setValidator(org.springframework.validation.Validator)}
	 * @utbot.throwsException {@link NullPointerException} in: dataBinder.setValidator(new PetValidator());
	 */
	@Test
	@DisplayName("initPetBinder: dataBinder.setValidator(new PetValidator()) : True -> ThrowNullPointerException")
	public void testInitPetBinder_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(PetValidator.class, (PetValidator petValidatorMock, Context context) -> {
			});

            /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.initPetBinder] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.PetController.initPetBinder(PetController.java:89) */
			petController.initPetBinder(null);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method initPetBinder(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initPetBinder(WebDataBinder)}
	 */
	@Test
	@DisplayName("initPetBinder: dataBinder = mock()")
	public void testInitPetBinder() {
		WebDataBinder dataBinderMock = mock(WebDataBinder.class);
		(((DataBinder) (doNothing()).when(dataBinderMock))).setValidator(any());

		petController.initPetBinder(dataBinderMock);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.initCreationForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.ui.ModelMap)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initCreationForm(Owner, ModelMap)}
	 * @utbot.invokes {@link Owner#addPet(Pet)}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("initCreationForm: OwnerAddPet -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testInitCreationForm_OwnerAddPet() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(Pet.class, (Pet petMock, Context context) -> {
			});
			Owner ownerMock = mock(Owner.class);
			(((Owner) (doNothing()).when(ownerMock))).addPet(any());

			String actual = petController.initCreationForm(ownerMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method initCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.ui.ModelMap)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initCreationForm(Owner, ModelMap)}
	 * @utbot.invokes {@link Owner#addPet(Pet)}
	 * @utbot.throwsException {@link NullPointerException} in: owner.addPet(pet);
	 */
	@Test
	@DisplayName("initCreationForm: owner.addPet(pet) : True -> ThrowNullPointerException")
	public void testInitCreationForm_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(Pet.class, (Pet petMock, Context context) -> {
			});

            /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.initCreationForm] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.PetController.initCreationForm(PetController.java:95) */
			petController.initCreationForm(null, null);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method initCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.ui.ModelMap)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initCreationForm(Owner, ModelMap)}
	 */
	@Test
	@DisplayName("initCreationForm: owner = mock(), model = collection")
	public void testInitCreationForm() {
		Owner ownerMock = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock))).addPet(any());
		ModelMap model = new ModelMap();

		String actual = petController.initCreationForm(ownerMock, model);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.processCreationForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processCreationForm: StringUtils.hasText(pet.getName()) && pet.isNew() : True -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessCreationForm_ResultHasErrors() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processCreationForm(null, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): True}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String)}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processCreationForm: pet.getBirthDate().isAfter(currentDate) : True -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessCreationForm_PetGetBirthDateIsAfter() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(true);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processCreationForm(null, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processCreationForm: StringUtils.hasText(pet.getName()) && pet.isNew() : False -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessCreationForm_StringUtilsHasTextAndPetIsNew() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processCreationForm(null, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link Owner#addPet(Pet)}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return "redirect:/owners/{ownerId}";}
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() : False -> return \"redirect:/owners/{ownerId}\"")
	public void testProcessCreationForm_NotResultHasErrors() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			(when(ownerRepositoryMock.save(any()))).thenReturn(null);
			Owner ownerMock = mock(Owner.class);
			(((Owner) (doNothing()).when(ownerMock))).addPet(any());
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(false);
			RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
			(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

			String actual = petController.processCreationForm(ownerMock, petMock, resultMock, redirectAttributesMock);

			String expected = "redirect:/owners/{ownerId}";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): True}
	 * @utbot.executesCondition {@code (if (StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null)
	 * result.rejectValue("name", "duplicate", "already exists");): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link Pet#getName()}
	 * @utbot.invokes {@link Owner#getPet(String, boolean)}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String, String)}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processCreationForm: owner.getPet(pet.getName(), true) != null : True -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessCreationForm_StringUtilsHasTextAndPetIsNewAndOwnerGetPetNotEqualsNull() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null), ((String) null));
			(when(petMock.isNew())).thenReturn(true);
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processCreationForm(ownerMock, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.throwsException {@link NullPointerException} when: StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null
	 */
	@Test
	@DisplayName("processCreationForm: StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.processCreationForm(PetController.java:103) */
		petController.processCreationForm(null, null, null, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.throwsException {@link NullPointerException} in: owner.addPet(pet);
	 */
	@Test
	@DisplayName("processCreationForm: owner.addPet(pet) : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_6() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(false);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, resultMock, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("message", "New Pet has been Added");
	 */
	@Test
	@DisplayName("processCreationForm: redirectAttributes.addFlashAttribute(\"message\", \"New Pet has been Added\") : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_8() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			(when(ownerRepositoryMock.save(any()))).thenReturn(null);
			Owner ownerMock = mock(Owner.class);
			(((Owner) (doNothing()).when(ownerMock))).addPet(any());
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(false);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(ownerMock, petMock, resultMock, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_4() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: result.rejectValue("birthDate", "typeMismatch.birthDate");
	 */
	@Test
	@DisplayName("processCreationForm: result.rejectValue(\"birthDate\", \"typeMismatch.birthDate\") : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_7() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(true);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): True}
	 * @utbot.throwsException {@link NullPointerException} when: StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null
	 */
	@Test
	@DisplayName("processCreationForm: StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_1() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null), ((String) null));
			(when(petMock.isNew())).thenReturn(true);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_3() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.throwsException {@link NullPointerException} when: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)
	 */
	@Test
	@DisplayName("processCreationForm: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate) -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_5() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, ((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): True}
	 * @utbot.executesCondition {@code (if (StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null)
	 * result.rejectValue("name", "duplicate", "already exists");): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: result.rejectValue("name", "duplicate", "already exists");
	 */
	@Test
	@DisplayName("processCreationForm: result.rejectValue(\"name\", \"duplicate\", \"already exists\") : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_2() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null), ((String) null));
			(when(petMock.isNew())).thenReturn(true);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processCreationForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(pet.getName()) && pet.isNew()): True}
	 * @utbot.executesCondition {@code (owner.getPet(pet.getName(), true) != null): True}
	 * @utbot.executesCondition {@code (if (StringUtils.hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null)
	 * result.rejectValue("name", "duplicate", "already exists");): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.throwsException {@link NullPointerException} when: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)
	 */
	@Test
	@DisplayName("processCreationForm: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate) -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_9() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null), ((String) null));
			(when(petMock.isNew())).thenReturn(true);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, ((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processCreationForm] produces [java.lang.NullPointerException] */
			petController.processCreationForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	@Test
	public void testProcessCreationFormByFuzzer() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("XZ");
		(when(petMock.isNew())).thenReturn(false);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer1() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("name");
		(when(petMock.isNew())).thenReturn(false);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer2() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("\n\t\r");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer3() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer4() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("message");
		(when(petMock1.isNew())).thenReturn(true);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer5() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("-3");
		(when(petMock1.isNew())).thenReturn(true);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processCreationForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer6() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("\n\t\r");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer7() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("message");
		(when(petMock.isNew())).thenReturn(false);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer8() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer9() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("birthDate");
		(when(petMock.isNew())).thenReturn(false);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer10() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("message");
		(when(petMock1.isNew())).thenReturn(true);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessCreationFormByFuzzer11() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("birthDate");
		(when(petMock1.isNew())).thenReturn(true);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processCreationForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.initUpdateForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initUpdateForm()

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#initUpdateForm()}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("initUpdateForm: -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testInitUpdateForm_ReturnVIEWS_PETS_CREATE_OR_UPDATE_FORM() {
		String actual = petController.initUpdateForm();

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetController.processUpdateForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processUpdateForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): True}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link Pet#getBirthDate()}
	 * @utbot.invokes {@link LocalDate#isAfter(java.time.chrono.ChronoLocalDate)}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String)}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processUpdateForm: pet.getBirthDate() != null : True -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessUpdateForm_PetGetBirthDateIsAfter() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(true);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processUpdateForm(ownerMock, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.returnsFrom {@code return VIEWS_PETS_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processUpdateForm: pet.getBirthDate() != null : False -> return VIEWS_PETS_CREATE_OR_UPDATE_FORM")
	public void testProcessUpdateForm_ResultHasErrors() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(true);

			String actual = petController.processUpdateForm(ownerMock, petMock, resultMock, null);

			String expected = "pets/createOrUpdatePetForm";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link Owner#addPet(Pet)}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return "redirect:/owners/{ownerId}";}
	 */
	@Test
	@DisplayName("processUpdateForm: result.hasErrors() : False -> return \"redirect:/owners/{ownerId}\"")
	public void testProcessUpdateForm_NotResultHasErrors() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			(when(ownerRepositoryMock.save(any()))).thenReturn(null);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			(((Owner) (doNothing()).when(ownerMock))).addPet(any());
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(false);
			RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
			(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

			String actual = petController.processUpdateForm(ownerMock, petMock, resultMock, redirectAttributesMock);

			String expected = "redirect:/owners/{ownerId}";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processUpdateForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.throwsException {@link NullPointerException} in: String petName = pet.getName();
	 */
	@Test
	@DisplayName("processUpdateForm: petName = pet.getName() : True -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.processUpdateForm(PetController.java:130) */
		petController.processUpdateForm(null, null, null, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.throwsException {@link NullPointerException} in: Pet existingPet = owner.getPet(petName, false);
	 */
	@Test
	@DisplayName("processUpdateForm: existingPet = owner.getPet(petName, false) : True -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_1() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processUpdateForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_8() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(false);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processUpdateForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_4() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(null, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate().isAfter(currentDate)): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: result.rejectValue("birthDate", "typeMismatch.birthDate");
	 */
	@Test
	@DisplayName("processUpdateForm: result.rejectValue(\"birthDate\", \"typeMismatch.birthDate\") : True -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_7() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			LocalDate localDateMock = mock(LocalDate.class);
			(when(localDateMock.isAfter(any()))).thenReturn(true);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, localDateMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processUpdateForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_3() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link Owner#addPet(Pet)}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("message", "Pet details has been edited");
	 */
	@Test
	@DisplayName("processUpdateForm: redirectAttributes.addFlashAttribute(\"message\", \"Pet details has been edited\") : True -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_6() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			(when(ownerRepositoryMock.save(any()))).thenReturn(null);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			(((Owner) (doNothing()).when(ownerMock))).addPet(any());
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			BindingResult resultMock = mock(BindingResult.class);
			(when(resultMock.hasErrors())).thenReturn(false);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, resultMock, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.throwsException {@link NullPointerException} when: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)
	 */
	@Test
	@DisplayName("processUpdateForm: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate) -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_5() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(((Pet) null));
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			LocalDate localDateMock = mock(LocalDate.class);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, ((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): True}
	 * @utbot.invokes {@link Integer#equals(Object)}
	 * @utbot.throwsException {@link NullPointerException} when: existingPet != null && !existingPet.getId().equals(pet.getId())
	 */
	@Test
	@DisplayName("processUpdateForm: existingPet != null && !existingPet.getId().equals(pet.getId()) -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_2() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			(when(petMock.getId())).thenReturn(((Integer) null), ((Integer) null));
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): True}
	 * @utbot.executesCondition {@code (!existingPet.getId().equals(pet.getId())): True}
	 * @utbot.throwsException {@link NullPointerException} in: result.rejectValue("name", "duplicate", "already exists");
	 */
	@Test
	@DisplayName("processUpdateForm: result.rejectValue(\"name\", \"duplicate\", \"already exists\") : True -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_9() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			Integer integer = -1;
			Integer integer1 = 0;
			(when(petMock.getId())).thenReturn(integer, integer1);
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): True}
	 * @utbot.executesCondition {@code (!existingPet.getId().equals(pet.getId())): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): False}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processUpdateForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_11() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			Integer integer = 0;
			(when(petMock.getId())).thenReturn(integer, integer);
			(when(petMock.getBirthDate())).thenReturn(((LocalDate) null));
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, null, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetController}
	 * @utbot.methodUnderTest {@link PetController#processUpdateForm(Owner, Pet, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (StringUtils.hasText(petName)): True}
	 * @utbot.executesCondition {@code (existingPet != null): True}
	 * @utbot.executesCondition {@code (!existingPet.getId().equals(pet.getId())): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate() != null): True}
	 * @utbot.throwsException {@link NullPointerException} when: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)
	 */
	@Test
	@DisplayName("processUpdateForm: pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate) -> ThrowNullPointerException")
	public void testProcessUpdateForm_ThrowNullPointerException_10() {
		MockedStatic mockedStatic = null;
		MockedStatic mockedStatic1 = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			mockedStatic1 = mockStatic(LocalDate.class);
			(mockedStatic1.when(LocalDate::now)).thenReturn(((LocalDate) null));
			Owner ownerMock = mock(Owner.class);
			Pet petMock = mock(Pet.class);
			(when(petMock.getName())).thenReturn(((String) null));
			Integer integer = -1;
			Integer integer1 = 0;
			(when(petMock.getId())).thenReturn(integer, integer1);
			LocalDate localDateMock = mock(LocalDate.class);
			(when(petMock.getBirthDate())).thenReturn(localDateMock, ((LocalDate) null));
			(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException] */
			petController.processUpdateForm(ownerMock, petMock, resultMock, null);
		} finally {
			mockedStatic.close();
			mockedStatic1.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method processUpdateForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	@Test
	public void testProcessUpdateFormByFuzzer() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("\n\t\r");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer1() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer2() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(0);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("message");
		(when(petMock1.getId())).thenReturn(1);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer3() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(Integer.MAX_VALUE);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("duplicate");
		(when(petMock1.getId())).thenReturn(Integer.MIN_VALUE);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer4() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(0);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("#$\\\"'");
		(when(petMock1.getId())).thenReturn(0);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer5() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(0);
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("typeMismatch.birthDate");
		(when(petMock1.getId())).thenReturn(0);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

		String actual = petController.processUpdateForm(ownerMock, petMock1, resultMock, redirectAttributesMock);

		String expected = "pets/createOrUpdatePetForm";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer6() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer7() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock = mock(Pet.class);
		(when(petMock.getName())).thenReturn("\n\t\r");
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer8() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(0);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("message");
		(when(petMock1.getId())).thenReturn(1);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer9() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(1);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("message");
		(when(petMock1.getId())).thenReturn(0);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer10() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(-1);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("typeMismatch.birthDate");
		(when(petMock1.getId())).thenReturn(-1);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(true);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any());
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessUpdateFormByFuzzer11() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerRepositoryMock.save(any()))).thenReturn(ownerMock);
		Owner ownerMock1 = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(-1);
		(when(ownerMock1.getPet(any(), anyBoolean()))).thenReturn(petMock);
		(((Owner) (doNothing()).when(ownerMock1))).addPet(any());
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("typeMismatch.birthDate");
		(when(petMock1.getId())).thenReturn(-1);
		LocalDate localDateMock = mock(LocalDate.class);
		(when(localDateMock.isAfter(any()))).thenReturn(false);
		(when(petMock1.getBirthDate())).thenReturn(localDateMock);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		RedirectAttributes redirectAttributesMock1 = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(redirectAttributesMock1);

		String actual = petController.processUpdateForm(ownerMock1, petMock1, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method processUpdateForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.samples.petclinic.owner.Pet, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	@Test
	public void testProcessUpdateFormByFuzzer12() {
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(petMock.getId())).thenReturn(((Integer) null));
		(when(ownerMock.getPet(any(), anyBoolean()))).thenReturn(petMock);
		Pet petMock1 = mock(Pet.class);
		(when(petMock1.getName())).thenReturn("duplicate");
		(when(petMock1.getId())).thenReturn(0);
		BindingResult resultMock = mock(BindingResult.class);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetController.processUpdateForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetController.processUpdateForm(PetController.java:135) */
		petController.processUpdateForm(ownerMock, petMock1, resultMock, redirectAttributesMock);
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
