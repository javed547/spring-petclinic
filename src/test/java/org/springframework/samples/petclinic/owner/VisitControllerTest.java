package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.emptyMap;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class VisitControllerTest {
	@InjectMocks
	private VisitController visitController;

	@Mock
	private OwnerRepository ownerRepositoryMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.VisitController.setAllowedFields

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setAllowedFields(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#setAllowedFields(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 */
	@Test
	@DisplayName("setAllowedFields: -> WebDataBinderSetDisallowedFields")
	public void testSetAllowedFields_WebDataBinderSetDisallowedFields() {
		WebDataBinder dataBinderMock = mock(WebDataBinder.class);
		(((DataBinder) (doNothing()).when(dataBinderMock))).setDisallowedFields(any());

		visitController.setAllowedFields(dataBinderMock);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method setAllowedFields(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#setAllowedFields(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 * @utbot.throwsException {@link NullPointerException} in: dataBinder.setDisallowedFields("id");
	 */
	@Test
	@DisplayName("setAllowedFields: dataBinder.setDisallowedFields(\"id\") : True -> ThrowNullPointerException")
	public void testSetAllowedFields_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.setAllowedFields] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.setAllowedFields(VisitController.java:52) */
		visitController.setAllowedFields(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit

	///region SYMBOLIC EXECUTION: ERROR SUITE for method loadPetWithVisit(int, int, java.util.Map)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 * @utbot.throwsException {@link IllegalArgumentException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("loadPetWithVisit: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowIllegalArgumentException")
	public void testLoadPetWithVisit_ThrowIllegalArgumentException() {
		Optional optional = empty();
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.IllegalArgumentException: Owner not found with id: -255. Please ensure the ID is correct ]
            org.springframework.samples.petclinic.owner.VisitController.lambda$loadPetWithVisit$0(VisitController.java:66)
            java.base/java.util.Optional.orElseThrow(Optional.java:403)
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:66) */
		visitController.loadPetWithVisit(-255, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 * @utbot.throwsException {@link ClassCastException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("loadPetWithVisit: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowClassCastException")
	public void testLoadPetWithVisit_ThrowClassCastException() {
		int[] intArray = {};
		Optional optional = of(intArray);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.ClassCastException: class [I cannot be cast to class org.springframework.samples.petclinic.owner.Owner ([I is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @2474defa)]
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:66) */
		visitController.loadPetWithVisit(-255, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 * @utbot.throwsException {@link NullPointerException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("loadPetWithVisit: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowNullPointerException")
	public void testLoadPetWithVisit_ThrowNullPointerException() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));

		/* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException] */
		visitController.loadPetWithVisit(-255, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 * @utbot.invokes {@link Owner#getPet(Integer)}
	 * @utbot.throwsException {@link NullPointerException} in: model.put("pet", pet);
	 */
	@Test
	@DisplayName("loadPetWithVisit: model.put(\"pet\", pet) : True -> ThrowNullPointerException")
	public void testLoadPetWithVisit_ThrowNullPointerException_1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

		/* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException] */
		visitController.loadPetWithVisit(-255, -256, null);
	}
	///endregion

	///region FUZZER: ERROR SUITE for method loadPetWithVisit(int, int, java.util.Map)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 */
	@Test
	@DisplayName("loadPetWithVisit: ownerId = -2147221504 (mutated from min), petId = max, model = Collections#emptyMap -> throw UnsupportedOperationException")
	public void testLoadPetWithVisitThrowsUOEWithCornerCase() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		Owner ownerMock = mock(Owner.class);
		Pet petMock = mock(Pet.class);
		(when(ownerMock.getPet(any(Integer.class)))).thenReturn(petMock);
		(when(optionalMock.orElseThrow(any()))).thenReturn(ownerMock);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);
		Map model = emptyMap();

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.UnsupportedOperationException]
            java.base/java.util.AbstractMap.put(AbstractMap.java:209)
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:70) */
		visitController.loadPetWithVisit(-2147221504, Integer.MAX_VALUE, model);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 */
	@Test
	@DisplayName("loadPetWithVisit: ownerId = -1, petId = zero (mutated from min), model = Collections#emptyMap -> throw NullPointerException")
	public void testLoadPetWithVisitThrowsNPEWithCornerCase() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));
		Map model = emptyMap();

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:66) */
		visitController.loadPetWithVisit(-1, 0, model);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 */
	@Test
	@DisplayName("loadPetWithVisit: ownerId = max (mutated from -1), petId = -1, model = Collections#emptyMap -> throw NullPointerException")
	public void testLoadPetWithVisitThrowsNPEWithCornerCase1() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		(when(optionalMock.orElseThrow(any()))).thenReturn(null);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);
		Map model = emptyMap();

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:69) */
		visitController.loadPetWithVisit(Integer.MAX_VALUE, -1, model);
	}
	///endregion

	///region FUZZER: TIMEOUTS for method loadPetWithVisit(int, int, java.util.Map)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#loadPetWithVisit(int, int, Map)}
	 */
	@Test
	@DisplayName("loadPetWithVisit: ownerId = -2036091383 (mutated from 111392265), petId = -1882689467 (mutated from -1882689339), model = Collections#emptyMap")
	@Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
	public void testLoadPetWithVisit() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		(when(optionalMock.orElseThrow(any()))).thenReturn(null);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);
		Map model = emptyMap();

        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
		assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> visitController.loadPetWithVisit(-2036091383, -1882689467, model));
	}
	///endregion

	///region OTHER: SUCCESSFUL EXECUTIONS for method loadPetWithVisit(int, int, java.util.Map)

	@Test
	public void testLoadPetWithVisit1() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(false);
		Integer integer = 0;
		(when(petMock.getId())).thenReturn(integer);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		LinkedHashMap model = new LinkedHashMap();

		Visit actual = visitController.loadPetWithVisit(0, 0, model);

		Visit expected = ((Visit) createInstance("org.springframework.samples.petclinic.owner.Visit"));
		LocalDate date = ((LocalDate) createInstance("java.time.LocalDate"));
		expected.setDate(date);

		LocalDate expectedDate = expected.getDate();
		LocalDate actualDate = actual.getDate();
		// java.time.LocalDate has overridden equals method
		assertEquals(expectedDate, actualDate);

		String actualDescription = actual.getDescription();
		assertNull(actualDescription);

		Integer actualId = actual.getId();
		assertNull(actualId);

	}
	///endregion

	///region OTHER: ERROR SUITE for method loadPetWithVisit(int, int, java.util.Map)

	@Test
	public void testLoadPetWithVisit2() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		LinkedHashMap model = new LinkedHashMap();

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:74) */
		visitController.loadPetWithVisit(0, 0, model);
	}

	@Test
	public void testLoadPetWithVisit3() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		ArrayList pets = new ArrayList();
		Pet petMock = mock(Pet.class);
		(when(petMock.isNew())).thenReturn(true);
		pets.add(petMock);
		pets.add(null);
		pets.add(null);
		setField(owner, "org.springframework.samples.petclinic.owner.Owner", "pets", pets);
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.Owner.getPet(Owner.java:118)
            org.springframework.samples.petclinic.owner.VisitController.loadPetWithVisit(VisitController.java:69) */
		visitController.loadPetWithVisit(0, 0, null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.VisitController.initNewVisitForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initNewVisitForm()

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#initNewVisitForm()}
	 * @utbot.returnsFrom {@code return "pets/createOrUpdateVisitForm";}
	 */
	@Test
	@DisplayName("initNewVisitForm: -> return \"pets/createOrUpdateVisitForm\"")
	public void testInitNewVisitForm_ReturnPetscreateOrUpdateVisitForm() {
		String actual = visitController.initNewVisitForm();

		String expected = "pets/createOrUpdateVisitForm";

		assertEquals(expected, actual);
	}
	///endregion

	///region FUZZER: TIMEOUTS for method initNewVisitForm()

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#initNewVisitForm()}
	 */
	@Test
	@DisplayName("initNewVisitForm: ")
	@Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
	public void testInitNewVisitForm() {
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
		assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> visitController.initNewVisitForm());
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processNewVisitForm(org.springframework.samples.petclinic.owner.Owner, int, org.springframework.samples.petclinic.owner.Visit, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.returnsFrom {@code return "pets/createOrUpdateVisitForm";}
	 */
	@Test
	@DisplayName("processNewVisitForm: result.hasErrors() : True -> return \"pets/createOrUpdateVisitForm\"")
	public void testProcessNewVisitForm_ResultHasErrors() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);

		String actual = visitController.processNewVisitForm(null, 1, null, resultMock, null);

		String expected = "pets/createOrUpdateVisitForm";

		assertEquals(expected, actual);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return "redirect:/owners/{ownerId}";}
	 */
	@Test
	@DisplayName("processNewVisitForm: result.hasErrors() : False -> return \"redirect:/owners/{ownerId}\"")
	public void testProcessNewVisitForm_NotResultHasErrors() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		Owner ownerMock = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock))).addVisit(any(), any());
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = visitController.processNewVisitForm(ownerMock, -255, null, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processNewVisitForm(org.springframework.samples.petclinic.owner.Owner, int, org.springframework.samples.petclinic.owner.Visit, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.throwsException {@link NullPointerException} in: owner.addVisit(petId, visit);
	 */
	@Test
	@DisplayName("processNewVisitForm: owner.addVisit(petId, visit) : True -> ThrowNullPointerException")
	public void testProcessNewVisitForm_ThrowNullPointerException_1() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm(VisitController.java:94) */
		visitController.processNewVisitForm(null, -255, null, resultMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("message", "Your visit has been booked");
	 */
	@Test
	@DisplayName("processNewVisitForm: redirectAttributes.addFlashAttribute(\"message\", \"Your visit has been booked\") : True -> ThrowNullPointerException")
	public void testProcessNewVisitForm_ThrowNullPointerException_2() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		Owner ownerMock = mock(Owner.class);
		(((Owner) (doNothing()).when(ownerMock))).addVisit(any(), any());
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm(VisitController.java:96) */
		visitController.processNewVisitForm(ownerMock, -255, null, resultMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link VisitController}
	 * @utbot.methodUnderTest {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processNewVisitForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessNewVisitForm_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.VisitController.processNewVisitForm(VisitController.java:90) */
		visitController.processNewVisitForm(null, -255, null, null, null);
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
