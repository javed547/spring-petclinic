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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import static java.util.Collections.emptyIterator;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class OwnerControllerTest {
	@InjectMocks
	private OwnerController ownerController;

	@Mock
	private OwnerRepository ownerRepositoryMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.setAllowedFields

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setAllowedFields(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#setAllowedFields(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 */
	@Test
	@DisplayName("setAllowedFields: -> WebDataBinderSetDisallowedFields")
	public void testSetAllowedFields_WebDataBinderSetDisallowedFields() {
		WebDataBinder dataBinderMock = mock(WebDataBinder.class);
		(((DataBinder) (doNothing()).when(dataBinderMock))).setDisallowedFields(any());

		ownerController.setAllowedFields(dataBinderMock);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method setAllowedFields(org.springframework.web.bind.WebDataBinder)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#setAllowedFields(WebDataBinder)}
	 * @utbot.invokes {@link WebDataBinder#setDisallowedFields(String[])}
	 * @utbot.throwsException {@link NullPointerException} in: dataBinder.setDisallowedFields("id");
	 */
	@Test
	@DisplayName("setAllowedFields: dataBinder.setDisallowedFields(\"id\") : True -> ThrowNullPointerException")
	public void testSetAllowedFields_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.setAllowedFields] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.setAllowedFields(OwnerController.java:59) */
		ownerController.setAllowedFields(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.findOwner

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method findOwner(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#findOwner(Integer)}
	 * @utbot.executesCondition {@code (ownerId == null): True}
	 * @utbot.returnsFrom {@code return ownerId == null ? new Owner() : this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct " + "and the owner exists in the database."));}
	 */
	@Test
	@DisplayName("findOwner: ownerId == null : True -> return ownerId == null ? new Owner() : this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \" + \"and the owner exists in the database.\"))")
	public void testFindOwner_OwnerIdEqualsNull() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(Owner.class, (Owner ownerMock, Context context) -> {
			});

			Owner actual = ownerController.findOwner(null);

			Owner expectedMock = mock(Owner.class);

			assertSame(expectedMock, actual);
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#findOwner(Integer)}
	 * @utbot.executesCondition {@code (ownerId == null): False}
	 * @utbot.invokes {@link OwnerRepository#findById(Integer)}
	 * @utbot.invokes {@link Optional#orElseThrow(java.util.function.Supplier)}
	 * @utbot.returnsFrom {@code return ownerId == null ? new Owner() : this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct " + "and the owner exists in the database."));}
	 */
	@Test
	@DisplayName("findOwner: ownerId == null : False -> OptionalOrElseThrow")
	public void testFindOwner_OwnerIdNotEqualsNull() throws Exception {
		Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
		Optional optional = of(owner);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer ownerId = 0;

		Owner actual = ownerController.findOwner(ownerId);

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

	///region SYMBOLIC EXECUTION: ERROR SUITE for method findOwner(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#findOwner(Integer)}
	 * @utbot.throwsException {@link IllegalArgumentException} in: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct " + "and the owner exists in the database."))
	 */
	@Test
	@DisplayName("findOwner: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \" + \"and the owner exists in the database.\")) : True -> ThrowIllegalArgumentException")
	public void testFindOwner_ThrowIllegalArgumentException() {
		Optional optional = empty();
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer ownerId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.findOwner] produces [java.lang.IllegalArgumentException: Owner not found with id: 0. Please ensure the ID is correct and the owner exists in the database.]
            org.springframework.samples.petclinic.owner.OwnerController.lambda$findOwner$0(OwnerController.java:66)
            java.base/java.util.Optional.orElseThrow(Optional.java:403)
            org.springframework.samples.petclinic.owner.OwnerController.findOwner(OwnerController.java:66) */
		ownerController.findOwner(ownerId);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#findOwner(Integer)}
	 * @utbot.throwsException {@link ClassCastException} in: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct " + "and the owner exists in the database."))
	 */
	@Test
	@DisplayName("findOwner: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \" + \"and the owner exists in the database.\")) : True -> ThrowClassCastException")
	public void testFindOwner_ThrowClassCastException() {
		byte[] byteArray = {};
		Optional optional = of(byteArray);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);
		Integer ownerId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.findOwner] produces [java.lang.ClassCastException: class [B cannot be cast to class org.springframework.samples.petclinic.owner.Owner ([B is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @6af56ac2)]
            org.springframework.samples.petclinic.owner.OwnerController.findOwner(OwnerController.java:66) */
		ownerController.findOwner(ownerId);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#findOwner(Integer)}
	 * @utbot.throwsException {@link NullPointerException} in: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct " + "and the owner exists in the database."))
	 */
	@Test
	@DisplayName("findOwner: this.owners.findById(ownerId).orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \" + \"and the owner exists in the database.\")) : True -> ThrowNullPointerException")
	public void testFindOwner_ThrowNullPointerException() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));
		Integer ownerId = 0;

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.findOwner] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.findOwner(OwnerController.java:66) */
		ownerController.findOwner(ownerId);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.initCreationForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initCreationForm()

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#initCreationForm()}
	 * @utbot.returnsFrom {@code return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("initCreationForm: -> return VIEWS_OWNER_CREATE_OR_UPDATE_FORM")
	public void testInitCreationForm_ReturnVIEWS_OWNER_CREATE_OR_UPDATE_FORM() {
		String actual = ownerController.initCreationForm();

		String expected = "owners/createOrUpdateOwnerForm";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.processCreationForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() : True -> return VIEWS_OWNER_CREATE_OR_UPDATE_FORM")
	public void testProcessCreationForm_ResultHasErrors() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = ownerController.processCreationForm(null, resultMock, redirectAttributesMock);

		String expected = "owners/createOrUpdateOwnerForm";

		assertEquals(expected, actual);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.invokes {@link Owner#getId()}
	 * @utbot.returnsFrom {@code return "redirect:/owners/" + owner.getId();}
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() : False -> return \"redirect:/owners/\" + owner.getId()")
	public void testProcessCreationForm_NotResultHasErrors() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		Owner ownerMock = mock(Owner.class);
		Integer integer = Integer.MIN_VALUE;
		(when(ownerMock.getId())).thenReturn(integer);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = ownerController.processCreationForm(ownerMock, resultMock, redirectAttributesMock);

		String expected = "redirect:/owners/-2147483648";

		assertEquals(expected, actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("error", "There was an error in creating the owner.");
	 */
	@Test
	@DisplayName("processCreationForm: redirectAttributes.addFlashAttribute(\"error\", \"There was an error in creating the owner.\") : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_1() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processCreationForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processCreationForm(OwnerController.java:78) */
		ownerController.processCreationForm(null, resultMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processCreationForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processCreationForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processCreationForm(OwnerController.java:77) */
		ownerController.processCreationForm(null, null, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("message", "New Owner Created");
	 */
	@Test
	@DisplayName("processCreationForm: redirectAttributes.addFlashAttribute(\"message\", \"New Owner Created\") : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_3() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processCreationForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processCreationForm(OwnerController.java:83) */
		ownerController.processCreationForm(null, resultMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link Owner#getId()}
	 * @utbot.throwsException {@link NullPointerException} in: return "redirect:/owners/" + owner.getId();
	 */
	@Test
	@DisplayName("processCreationForm: return \"redirect:/owners/\" + owner.getId() : True -> ThrowNullPointerException")
	public void testProcessCreationForm_ThrowNullPointerException_2() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processCreationForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processCreationForm(OwnerController.java:84) */
		ownerController.processCreationForm(null, resultMock, redirectAttributesMock);
	}
	///endregion

	///region OTHER: ERROR SUITE for method processCreationForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	@Test
	public void testProcessCreationForm1() throws Exception {
		Object object = createInstance("java.lang.Object");
		(when(ownerRepositoryMock.save(any()))).thenReturn(object);
		Owner ownerMock = mock(Owner.class);
		Integer integer = -13;
		(when(ownerMock.getId())).thenReturn(integer);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processCreationForm] produces [java.lang.ClassCastException: class java.lang.Object cannot be cast to class org.springframework.samples.petclinic.owner.Owner (java.lang.Object is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @6af56ac2)]
            org.springframework.samples.petclinic.owner.OwnerRepository$MockitoMock$Y1gt77Ej.save(Unknown Source)
            org.springframework.samples.petclinic.owner.OwnerRepository$MockitoMock$Y1gt77Ej.save(Unknown Source)
            org.springframework.samples.petclinic.owner.OwnerController.processCreationForm(OwnerController.java:82) */
		ownerController.processCreationForm(ownerMock, resultMock, redirectAttributesMock);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.initFindForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initFindForm()

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#initFindForm()}
	 * @utbot.returnsFrom {@code return "owners/findOwners";}
	 */
	@Test
	@DisplayName("initFindForm: -> return \"owners/findOwners\"")
	public void testInitFindForm_ReturnOwnersfindOwners() {
		String actual = ownerController.initFindForm();

		String expected = "owners/findOwners";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.processFindForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): True}
	 * @utbot.invokes {@link Owner#setLastName(String)}
	 * @utbot.returnsFrom {@code return "owners/findOwners";}
	 */
	@Test
	@DisplayName("processFindForm: owner.getLastName() == null : True -> return \"owners/findOwners\"")
	public void testProcessFindForm_OwnerGetLastNameEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(true);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());

			String actual = ownerController.processFindForm(32, ownerMock, resultMock, null);

			String expected = "owners/findOwners";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): False}
	 * @utbot.returnsFrom {@code return "owners/findOwners";}
	 */
	@Test
	@DisplayName("processFindForm: owner.getLastName() == null : False -> return \"owners/findOwners\"")
	public void testProcessFindForm_OwnerGetLastNameNotEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(true);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));
			BindingResult resultMock = mock(BindingResult.class);
			(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());

			String actual = ownerController.processFindForm(16, ownerMock, resultMock, null);

			String expected = "owners/findOwners";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): False}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): False}
	 * @utbot.executesCondition {@code (ownersResults.getTotalElements() == 1): True}
	 * @utbot.invokes {@link Owner#getLastName()}
	 * @utbot.invokes {@link Owner#getLastName()}
	 * @utbot.invokes org.springframework.samples.petclinic.owner.OwnerController#findPaginatedForOwnersLastName(int, java.lang.String)
	 * @utbot.invokes {@link Page#getTotalElements()}
	 * @utbot.invokes {@link Page#iterator()}
	 * @utbot.invokes {@link Iterator#next()}
	 * @utbot.throwsException {@link java.util.NoSuchElementException} in: owner = ownersResults.iterator().next();
	 */
	@Test
	@DisplayName("processFindForm: owner = ownersResults.iterator().next() -> ThrowNoSuchElementException")
	public void testProcessFindForm_ThrowNoSuchElementException() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

			assertThrows(java.util.NoSuchElementException.class, () -> ownerController.processFindForm(32, ownerMock, null, null));
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): False}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): False}
	 * @utbot.executesCondition {@code (ownersResults.getTotalElements() == 1): True}
	 * @utbot.throwsException {@link ClassCastException} in: owner = ownersResults.iterator().next();
	 */
	@Test
	@DisplayName("processFindForm: owner = ownersResults.iterator().next() -> ThrowClassCastException")
	public void testProcessFindForm_ThrowClassCastException() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.ClassCastException: The object with type java.lang.Object can not be casted to org.springframework.samples.petclinic.owner.Owner] */
			ownerController.processFindForm(64, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.throwsException {@link NullPointerException} when: owner.getLastName() == null
	 */
	@Test
	@DisplayName("processFindForm: owner.getLastName() == null -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:96) */
		ownerController.processFindForm(-255, null, null, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): True}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: result.rejectValue("lastName", "notFound", "not found");
	 */
	@Test
	@DisplayName("processFindForm: result.rejectValue(\"lastName\", \"notFound\", \"not found\") : True -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException_1() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(true);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException] */
			ownerController.processFindForm(-255, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): True}
	 * @utbot.throwsException {@link NullPointerException} when: ownersResults.isEmpty()
	 */
	@Test
	@DisplayName("processFindForm: ownersResults.isEmpty() -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException_3() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(((Page) null));
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException] */
			ownerController.processFindForm(-255, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): True}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): False}
	 * @utbot.executesCondition {@code (ownersResults.getTotalElements() == 1): True}
	 * @utbot.invokes {@link Iterator#next()}
	 * @utbot.throwsException {@link NullPointerException} in: owner = ownersResults.iterator().next();
	 */
	@Test
	@DisplayName("processFindForm: owner = ownersResults.iterator().next() -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException_2() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			(when(pageMock.iterator())).thenReturn(((Iterator) null));
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException] */
			ownerController.processFindForm(-255, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): True}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): False}
	 * @utbot.executesCondition {@code (ownersResults.getTotalElements() == 1): False}
	 * @utbot.invokes org.springframework.samples.petclinic.owner.OwnerController#addPaginationModel(int, org.springframework.ui.Model, org.springframework.data.domain.Page)
	 * @utbot.throwsException {@link NullPointerException} in: return addPaginationModel(page, model, ownersResults);
	 */
	@Test
	@DisplayName("processFindForm: return addPaginationModel(page, model, ownersResults) : True -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException_4() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(-9223372036854775806L);
			(when(pageMock.getContent())).thenReturn(((List) null));
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException] */
			ownerController.processFindForm(-255, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
	 * @utbot.executesCondition {@code (owner.getLastName() == null): False}
	 * @utbot.executesCondition {@code (ownersResults.isEmpty()): False}
	 * @utbot.executesCondition {@code (ownersResults.getTotalElements() == 1): True}
	 * @utbot.invokes {@link Owner#getId()}
	 * @utbot.throwsException {@link NullPointerException} in: return "redirect:/owners/" + owner.getId();
	 */
	@Test
	@DisplayName("processFindForm: return \"redirect:/owners/\" + owner.getId() : True -> ThrowNullPointerException")
	public void testProcessFindForm_ThrowNullPointerException_5() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException] */
			ownerController.processFindForm(-255, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindFormByFuzzer() {
		Page pageMock = mock(Page.class);
		(when(pageMock.isEmpty())).thenReturn(true);
		(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn("not found");
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		Model modelMock = mock(Model.class);

		String actual = ownerController.processFindForm(65, ownerMock, resultMock, modelMock);

		String expected = "owners/findOwners";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessFindFormByFuzzer1() {
		Page pageMock = mock(Page.class);
		(when(pageMock.isEmpty())).thenReturn(true);
		(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn(((String) null));
		(((Person) (doNothing()).when(ownerMock))).setLastName(any());
		BindingResult resultMock = mock(BindingResult.class);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		Model modelMock = mock(Model.class);

		String actual = ownerController.processFindForm(Integer.MIN_VALUE, ownerMock, resultMock, modelMock);

		String expected = "owners/findOwners";

		assertEquals(expected, actual);
	}

	@Test
	public void testProcessFindFormByFuzzer2() {
		Page pageMock = mock(Page.class);
		(when(pageMock.isEmpty())).thenReturn(false);
		(when(pageMock.getTotalElements())).thenReturn(0L);
		List listMock = mock(List.class);
		(when(pageMock.getContent())).thenReturn(listMock);
		(when(pageMock.getTotalPages())).thenReturn(0);
		(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn(((String) null));
		(((Person) (doNothing()).when(ownerMock))).setLastName(any());
		BindingResult resultMock = mock(BindingResult.class);
		Model modelMock = mock(Model.class);
		Model modelMock1 = mock(Model.class);
		(when(modelMock.addAttribute(any(), any()))).thenReturn(modelMock1);

		String actual = ownerController.processFindForm(2, ownerMock, resultMock, modelMock);

		String expected = "owners/ownersList";

		assertEquals(expected, actual);
	}
	///endregion

	///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindFormByFuzzer3() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn(((String) null));
		(((Person) (doNothing()).when(ownerMock))).setLastName(any());
		BindingResult resultMock = mock(BindingResult.class);
		Model modelMock = mock(Model.class);

		assertThrows(IllegalArgumentException.class, () -> ownerController.processFindForm(-2147483646, ownerMock, resultMock, modelMock));
	}
	///endregion

	///region FUZZER: ERROR SUITE for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindFormByFuzzer4() {
		Page pageMock = mock(Page.class);
		(when(pageMock.isEmpty())).thenReturn(false);
		(when(pageMock.getTotalElements())).thenReturn(1L);
		Iterator iterator = emptyIterator();
		(when(pageMock.iterator())).thenReturn(iterator);
		(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn("notFound");
		BindingResult resultMock = mock(BindingResult.class);
		Model modelMock = mock(Model.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.util.NoSuchElementException]
            java.base/java.util.Collections$EmptyIterator.next(Collections.java:4310)
            org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:110) */
		ownerController.processFindForm(5, ownerMock, resultMock, modelMock);
	}

	@Test
	public void testProcessFindFormByFuzzer5() {
		Page pageMock = mock(Page.class);
		(when(pageMock.isEmpty())).thenReturn(false);
		(when(pageMock.getTotalElements())).thenReturn(1L);
		Iterator iterator = emptyIterator();
		(when(pageMock.iterator())).thenReturn(iterator);
		(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getLastName())).thenReturn(((String) null));
		(((Person) (doNothing()).when(ownerMock))).setLastName(any());
		BindingResult resultMock = mock(BindingResult.class);
		Model modelMock = mock(Model.class);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.util.NoSuchElementException]
            java.base/java.util.Collections$EmptyIterator.next(Collections.java:4310)
            org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:110) */
		ownerController.processFindForm(5, ownerMock, resultMock, modelMock);
	}
	///endregion

	///region OTHER: SUCCESSFUL EXECUTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindForm1() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(-9223372036854775806L, 0L);
			(when(pageMock.getContent())).thenReturn(((List) null));
			(when(pageMock.getTotalPages())).thenReturn(0);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));
			Model modelMock = mock(Model.class);
			(when(modelMock.addAttribute(any(), any()))).thenReturn(((Model) null), ((Model) null));

			String actual = ownerController.processFindForm(0, ownerMock, null, modelMock);

			String expected = "owners/ownersList";

			assertEquals(expected, actual);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region OTHER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindForm2() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));
			BindingResult resultMock = mock(BindingResult.class);

			assertThrows(IllegalArgumentException.class, () -> ownerController.processFindForm(0, ownerMock, resultMock, null));
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region OTHER: ERROR SUITE for method processFindForm(int, org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, org.springframework.ui.Model)

	@Test
	public void testProcessFindForm3() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(true);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:104) */
			ownerController.processFindForm(0, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	@Test
	public void testProcessFindForm4() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(((Page) null));
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:102) */
			ownerController.processFindForm(0, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}

	@Test
	public void testProcessFindForm5() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			(when(ownerMock.getLastName())).thenReturn(((String) null), ((String) null));
			(((Person) (doNothing()).when(ownerMock))).setLastName(any());
			BindingResult resultMock = mock(BindingResult.class);

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:111) */
			ownerController.processFindForm(0, ownerMock, resultMock, null);
		} finally {
			mockedStatic.close();
		}
	}

	@Test
	public void testProcessFindForm6() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(PageRequest.class);
			PageRequest pageRequestMock = mock(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(pageRequestMock);
			Page pageMock = mock(Page.class);
			(when(pageMock.isEmpty())).thenReturn(false);
			(when(pageMock.getTotalElements())).thenReturn(1L);
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			Iterator iterator = arrayList.iterator();
			(when(pageMock.iterator())).thenReturn(iterator);
			(when(ownerRepositoryMock.findByLastNameStartingWith(any(), any()))).thenReturn(pageMock);
			Owner ownerMock = mock(Owner.class);
			String string = "";
			(when(ownerMock.getLastName())).thenReturn(string, ((String) null));

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processFindForm] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.OwnerController.processFindForm(OwnerController.java:111) */
			ownerController.processFindForm(0, ownerMock, null, null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.initUpdateOwnerForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method initUpdateOwnerForm()

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#initUpdateOwnerForm()}
	 * @utbot.returnsFrom {@code return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("initUpdateOwnerForm: -> return VIEWS_OWNER_CREATE_OR_UPDATE_FORM")
	public void testInitUpdateOwnerForm_ReturnVIEWS_OWNER_CREATE_OR_UPDATE_FORM() {
		String actual = ownerController.initUpdateOwnerForm();

		String expected = "owners/createOrUpdateOwnerForm";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method processUpdateOwnerForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, int, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;}
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: result.hasErrors() : True -> return VIEWS_OWNER_CREATE_OR_UPDATE_FORM")
	public void testProcessUpdateOwnerForm_ResultHasErrors() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = ownerController.processUpdateOwnerForm(null, resultMock, 4, redirectAttributesMock);

		String expected = "owners/createOrUpdateOwnerForm";

		assertEquals(expected, actual);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.executesCondition {@code (owner.getId() != ownerId): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String, String)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return "redirect:/owners/{ownerId}/edit";}
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: owner.getId() != ownerId : True -> return \"redirect:/owners/{ownerId}/edit\"")
	public void testProcessUpdateOwnerForm_OwnerGetIdNotEqualsOwnerId() {
		Owner ownerMock = mock(Owner.class);
		Integer integer = 254;
		(when(ownerMock.getId())).thenReturn(integer);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = ownerController.processUpdateOwnerForm(ownerMock, resultMock, -255, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}/edit";

		assertEquals(expected, actual);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.executesCondition {@code (owner.getId() != ownerId): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.returnsFrom {@code return "redirect:/owners/{ownerId}";}
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: owner.getId() != ownerId : False -> return \"redirect:/owners/{ownerId}\"")
	public void testProcessUpdateOwnerForm_OwnerGetIdEqualsOwnerId() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		Owner ownerMock = mock(Owner.class);
		Integer integer = -255;
		(when(ownerMock.getId())).thenReturn(integer);
		(((BaseEntity) (doNothing()).when(ownerMock))).setId(any());
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		RedirectAttributes redirectAttributesMock = mock(RedirectAttributes.class);
		(when(redirectAttributesMock.addFlashAttribute(any(), any()))).thenReturn(((RedirectAttributes) null));

		String actual = ownerController.processUpdateOwnerForm(ownerMock, resultMock, -255, redirectAttributesMock);

		String expected = "redirect:/owners/{ownerId}";

		assertEquals(expected, actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method processUpdateOwnerForm(org.springframework.samples.petclinic.owner.Owner, org.springframework.validation.BindingResult, int, org.springframework.web.servlet.mvc.support.RedirectAttributes)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): True}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("error", "There was an error in updating the owner.");
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: redirectAttributes.addFlashAttribute(\"error\", \"There was an error in updating the owner.\") : True -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException_2() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(true);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:142) */
		ownerController.processUpdateOwnerForm(null, resultMock, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.throwsException {@link NullPointerException} when: owner.getId() != ownerId
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: owner.getId() != ownerId -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException_3() {
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:146) */
		ownerController.processUpdateOwnerForm(null, resultMock, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.invokes {@link Integer#intValue()}
	 * @utbot.throwsException {@link NullPointerException} when: owner.getId() != ownerId
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: owner.getId() != ownerId -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException() {
		Owner ownerMock = mock(Owner.class);
		(when(ownerMock.getId())).thenReturn(((Integer) null));
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:146) */
		ownerController.processUpdateOwnerForm(ownerMock, resultMock, 64, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.throwsException {@link NullPointerException} when: result.hasErrors()
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: result.hasErrors() -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException_1() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:141) */
		ownerController.processUpdateOwnerForm(null, null, -255, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.executesCondition {@code (owner.getId() != ownerId): True}
	 * @utbot.invokes {@link BindingResult#rejectValue(String, String, String)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("error", "Owner ID mismatch. Please try again.");
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: redirectAttributes.addFlashAttribute(\"error\", \"Owner ID mismatch. Please try again.\") : True -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException_4() {
		Owner ownerMock = mock(Owner.class);
		Integer integer = 1;
		(when(ownerMock.getId())).thenReturn(integer);
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);
		(((Errors) (doNothing()).when(resultMock))).rejectValue(any(), any(), any());

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:148) */
		ownerController.processUpdateOwnerForm(ownerMock, resultMock, 0, null);
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)}
	 * @utbot.executesCondition {@code (result.hasErrors()): False}
	 * @utbot.executesCondition {@code (owner.getId() != ownerId): False}
	 * @utbot.invokes {@link OwnerRepository#save(Object)}
	 * @utbot.invokes {@link RedirectAttributes#addFlashAttribute(String, Object)}
	 * @utbot.throwsException {@link NullPointerException} in: redirectAttributes.addFlashAttribute("message", "Owner Values Updated");
	 */
	@Test
	@DisplayName("processUpdateOwnerForm: redirectAttributes.addFlashAttribute(\"message\", \"Owner Values Updated\") : True -> ThrowNullPointerException")
	public void testProcessUpdateOwnerForm_ThrowNullPointerException_5() {
		(when(ownerRepositoryMock.save(any()))).thenReturn(null);
		Owner ownerMock = mock(Owner.class);
		Integer integer = -255;
		(when(ownerMock.getId())).thenReturn(integer);
		(((BaseEntity) (doNothing()).when(ownerMock))).setId(any());
		BindingResult resultMock = mock(BindingResult.class);
		(when(resultMock.hasErrors())).thenReturn(false);

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.processUpdateOwnerForm(OwnerController.java:154) */
		ownerController.processUpdateOwnerForm(ownerMock, resultMock, -255, null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.OwnerController.showOwner

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method showOwner(int)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 * @utbot.invokes {@link Optional#orElseThrow(java.util.function.Supplier)}
	 * @utbot.invokes {@link ModelAndView#addObject(Object)}
	 * @utbot.returnsFrom {@code return mav;}
	 */
	@Test
	@DisplayName("showOwner: IntegerValueOf -> OptionalOrElseThrow")
	public void testShowOwner_OptionalOrElseThrow() throws Exception {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(ModelAndView.class, (ModelAndView modelAndViewMock, Context context) -> (when(modelAndViewMock.addObject(any()))).thenReturn(null));
			Owner owner = ((Owner) createInstance("org.springframework.samples.petclinic.owner.Owner"));
			Optional optional = of(owner);
			(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

			ModelAndView actual = ownerController.showOwner(-255);

			ModelAndView expectedMock = mock(ModelAndView.class);

			assertSame(expectedMock, actual);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method showOwner(int)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 * @utbot.throwsException {@link IllegalArgumentException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("showOwner: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowIllegalArgumentException")
	public void testShowOwner_ThrowIllegalArgumentException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(ModelAndView.class, (ModelAndView modelAndViewMock, Context context) -> {
			});
			Optional optional = empty();
			(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.showOwner] produces [java.lang.IllegalArgumentException: Owner not found with id: -255. Please ensure the ID is correct ]
                org.springframework.samples.petclinic.owner.OwnerController.lambda$showOwner$1(OwnerController.java:167)
                java.base/java.util.Optional.orElseThrow(Optional.java:403)
                org.springframework.samples.petclinic.owner.OwnerController.showOwner(OwnerController.java:167) */
			ownerController.showOwner(-255);
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 * @utbot.throwsException {@link ClassCastException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("showOwner: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowClassCastException")
	public void testShowOwner_ThrowClassCastException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(ModelAndView.class, (ModelAndView modelAndViewMock, Context context) -> {
			});
			byte[] byteArray = {};
			Optional optional = of(byteArray);
			(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optional);

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.showOwner] produces [java.lang.ClassCastException: class [B cannot be cast to class org.springframework.samples.petclinic.owner.Owner ([B is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Owner is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @6af56ac2)]
                org.springframework.samples.petclinic.owner.OwnerController.showOwner(OwnerController.java:167) */
			ownerController.showOwner(-255);
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 * @utbot.throwsException {@link NullPointerException} in: Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException("Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	 */
	@Test
	@DisplayName("showOwner: owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(\"Owner not found with id: \" + ownerId + \". Please ensure the ID is correct \")) : True -> ThrowNullPointerException")
	public void testShowOwner_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(ModelAndView.class, (ModelAndView modelAndViewMock, Context context) -> {
			});
			(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));

            /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.showOwner] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.owner.OwnerController.showOwner(OwnerController.java:167) */
			ownerController.showOwner(-255);
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method showOwner(int)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 */
	@Test
	@DisplayName("showOwner: ownerId = -2147483644 (mutated from min)")
	public void testShowOwner() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		Owner ownerMock = mock(Owner.class);
		(when(optionalMock.orElseThrow(any()))).thenReturn(ownerMock);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);

		ModelAndView actual = ownerController.showOwner(-2147483644);

		ModelAndView expected = ((ModelAndView) createInstance("org.springframework.web.servlet.ModelAndView"));
		String view = "owners/ownerDetails";
		setField(expected, "org.springframework.web.servlet.ModelAndView", "view", view);
		ModelMap model = ((ModelMap) createInstance("org.springframework.ui.ModelMap"));
		Object head = createInstance("java.util.LinkedHashMap$Entry");
		setField(model, "java.util.LinkedHashMap", "head", head);
		Object tail = createInstance("java.util.LinkedHashMap$Entry");
		setField(model, "java.util.LinkedHashMap", "tail", tail);
		Object[] table = createArray("java.util.HashMap$Node", 16);
		Object entry = createInstance("java.util.LinkedHashMap$Entry");
		table[0] = entry;
		setField(model, "java.util.HashMap", "table", table);
		Set entrySet = new LinkedHashSet();
		Object entry1 = createInstance("java.util.LinkedHashMap$Entry");
		entrySet.add(entry1);
		setField(model, "java.util.HashMap", "entrySet", entrySet);
		setField(model, "java.util.HashMap", "size", 1);
		setField(model, "java.util.HashMap", "modCount", 1);
		setField(model, "java.util.HashMap", "threshold", 12);
		setField(model, "java.util.HashMap", "loadFactor", 0.75f);
		setField(expected, "org.springframework.web.servlet.ModelAndView", "model", model);

		Object expectedView = getFieldValue(expected, "org.springframework.web.servlet.ModelAndView", "view");
		Object actualView = getFieldValue(actual, "org.springframework.web.servlet.ModelAndView", "view");
		assertEquals(expectedView, actualView);

		ModelMap expectedModel = ((ModelMap) getFieldValue(expected, "org.springframework.web.servlet.ModelAndView", "model"));
		ModelMap actualModel = ((ModelMap) getFieldValue(actual, "org.springframework.web.servlet.ModelAndView", "model"));
		Object expectedModelHead = getFieldValue(expectedModel, "java.util.LinkedHashMap", "head");
		Object actualModelHead = getFieldValue(actualModel, "java.util.LinkedHashMap", "head");

		Object expectedModelTail = getFieldValue(expectedModel, "java.util.LinkedHashMap", "tail");
		Object actualModelTail = getFieldValue(actualModel, "java.util.LinkedHashMap", "tail");

		boolean actualModelAccessOrder = ((Boolean) getFieldValue(actualModel, "java.util.LinkedHashMap", "accessOrder"));
		assertFalse(actualModelAccessOrder);

		Object expectedModelTable = getFieldValue(expectedModel, "java.util.HashMap", "table");
		Object actualModelTable = getFieldValue(actualModel, "java.util.HashMap", "table");
		int expectedModelTableSize = getArrayLength(expectedModelTable);
		assertEquals(expectedModelTableSize, getArrayLength(actualModelTable));
		assertTrue(deepEquals(expectedModelTable, actualModelTable));

		Set expectedModelEntrySet = ((Set) getFieldValue(expectedModel, "java.util.HashMap", "entrySet"));
		Set actualModelEntrySet = ((Set) getFieldValue(actualModel, "java.util.HashMap", "entrySet"));
		assertTrue(deepEquals(expectedModelEntrySet, actualModelEntrySet));

		int expectedModelSize = ((Integer) getFieldValue(expectedModel, "java.util.HashMap", "size"));
		int actualModelSize = ((Integer) getFieldValue(actualModel, "java.util.HashMap", "size"));
		assertEquals(expectedModelSize, actualModelSize);

		int expectedModelModCount = ((Integer) getFieldValue(expectedModel, "java.util.HashMap", "modCount"));
		int actualModelModCount = ((Integer) getFieldValue(actualModel, "java.util.HashMap", "modCount"));
		assertEquals(expectedModelModCount, actualModelModCount);

		int expectedModelThreshold = ((Integer) getFieldValue(expectedModel, "java.util.HashMap", "threshold"));
		int actualModelThreshold = ((Integer) getFieldValue(actualModel, "java.util.HashMap", "threshold"));
		assertEquals(expectedModelThreshold, actualModelThreshold);

		float expectedModelLoadFactor = ((Float) getFieldValue(expectedModel, "java.util.HashMap", "loadFactor"));
		float actualModelLoadFactor = ((Float) getFieldValue(actualModel, "java.util.HashMap", "loadFactor"));
		assertEquals(expectedModelLoadFactor, actualModelLoadFactor, 1.0E-6f);

		Set actualModelKeySet = ((Set) getFieldValue(actualModel, "java.util.AbstractMap", "keySet"));
		assertNull(actualModelKeySet);

		Collection actualModelValues = ((Collection) getFieldValue(actualModel, "java.util.AbstractMap", "values"));
		assertNull(actualModelValues);

		HttpStatusCode actualStatus = actual.getStatus();
		assertNull(actualStatus);

		boolean actualCleared = ((Boolean) getFieldValue(actual, "org.springframework.web.servlet.ModelAndView", "cleared"));
		assertFalse(actualCleared);

	}
	///endregion

	///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method showOwner(int)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 */
	@Test
	@DisplayName("showOwner: ownerId = -3 (mutated from -1) -> throw IllegalArgumentException")
	public void testShowOwnerThrowsIAE() throws Throwable {
		Optional optionalMock = mock(Optional.class);
		(when(optionalMock.orElseThrow(any()))).thenReturn(null);
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(optionalMock);

		assertThrows(IllegalArgumentException.class, () -> ownerController.showOwner(-3));
	}
	///endregion

	///region FUZZER: ERROR SUITE for method showOwner(int)

	/**
	 * @utbot.classUnderTest {@link OwnerController}
	 * @utbot.methodUnderTest {@link OwnerController#showOwner(int)}
	 */
	@Test
	@DisplayName("showOwner: ownerId = 2147483643 (mutated from max) -> throw NullPointerException")
	public void testShowOwnerThrowsNPE() {
		(when(ownerRepositoryMock.findById(((Integer) any(Integer.class))))).thenReturn(((Optional) null));

        /* This test fails because method [org.springframework.samples.petclinic.owner.OwnerController.showOwner] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.OwnerController.showOwner(OwnerController.java:167) */
		ownerController.showOwner(2147483643);
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
