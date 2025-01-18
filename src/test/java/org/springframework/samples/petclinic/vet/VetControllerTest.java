package org.springframework.samples.petclinic.vet;

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
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class VetControllerTest {
	@InjectMocks
	private VetController vetController;

	@Mock
	private VetRepository vetRepositoryMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.vet.VetController.showVetList

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method showVetList(int, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 * @utbot.invokes org.springframework.samples.petclinic.vet.VetController#findPaginated(int)
	 * @utbot.invokes {@link Page#toList()}
	 * @utbot.invokes {@link List#addAll(Collection)}
	 * @utbot.invokes org.springframework.samples.petclinic.vet.VetController#addPaginationModel(int, org.springframework.data.domain.Page, org.springframework.ui.Model)
	 * @utbot.returnsFrom {@code return addPaginationModel(page, paginated, model);}
	 */
	@Test
	@DisplayName("showVetList: VetControllerFindPaginated -> return addPaginationModel(page, paginated, model)")
	public void testShowVetList_VetControllerAddPaginationModel() {
		MockedConstruction mockedConstruction = null;
		MockedStatic mockedStatic = null;
		try {
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(arrayList));
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.toList())).thenReturn(arrayList);
			(when(pageMock.getContent())).thenReturn(((List) null));
			(when(pageMock.getTotalPages())).thenReturn(0);
			(when(pageMock.getTotalElements())).thenReturn(0L);
			(when(vetRepositoryMock.findAll(any()))).thenReturn(pageMock);
			Model modelMock = mock(Model.class);
			(when(modelMock.addAttribute(any(), any()))).thenReturn(((Model) null), ((Model) null), ((Model) null), ((Model) null));

			String actual = vetController.showVetList(-255, modelMock);

			String expected = "vets/vetList";

			assertEquals(expected, actual);
		} finally {
			mockedConstruction.close();
			mockedStatic.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method showVetList(int, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 * @utbot.throwsException {@link NullPointerException} in: vets.getVetList().addAll(paginated.toList());
	 */
	@Test
	@DisplayName("showVetList: vets.getVetList().addAll(paginated.toList()) : True -> ThrowNullPointerException")
	public void testShowVetList_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		MockedStatic mockedStatic = null;
		try {
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(null));
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			(when(vetRepositoryMock.findAll(any()))).thenReturn(((Page) null));

			/* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showVetList] produces [java.lang.NullPointerException] */
			vetController.showVetList(-255, null);
		} finally {
			mockedConstruction.close();
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 * @utbot.invokes {@link List#addAll(Collection)}
	 * @utbot.throwsException {@link NullPointerException} in: vets.getVetList().addAll(paginated.toList());
	 */
	@Test
	@DisplayName("showVetList: vets.getVetList().addAll(paginated.toList()) : True -> ThrowNullPointerException")
	public void testShowVetList_ThrowNullPointerException_1() {
		MockedConstruction mockedConstruction = null;
		MockedStatic mockedStatic = null;
		try {
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(null));
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.toList())).thenReturn(((List) null));
			(when(vetRepositoryMock.findAll(any()))).thenReturn(pageMock);

			/* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showVetList] produces [java.lang.NullPointerException] */
			vetController.showVetList(-255, null);
		} finally {
			mockedConstruction.close();
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 * @utbot.invokes {@link List#addAll(Collection)}
	 * @utbot.invokes org.springframework.samples.petclinic.vet.VetController#addPaginationModel(int, org.springframework.data.domain.Page, org.springframework.ui.Model)
	 * @utbot.throwsException {@link NullPointerException} in: return addPaginationModel(page, paginated, model);
	 */
	@Test
	@DisplayName("showVetList: return addPaginationModel(page, paginated, model) : True -> ThrowNullPointerException")
	public void testShowVetList_ThrowNullPointerException_2() {
		MockedConstruction mockedConstruction = null;
		MockedStatic mockedStatic = null;
		try {
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(arrayList));
			mockedStatic = mockStatic(PageRequest.class);
			(mockedStatic.when(() -> PageRequest.of(anyInt(), anyInt()))).thenReturn(((PageRequest) null));
			Page pageMock = mock(Page.class);
			(when(pageMock.toList())).thenReturn(arrayList);
			(when(pageMock.getContent())).thenReturn(((List) null));
			(when(vetRepositoryMock.findAll(any()))).thenReturn(pageMock);

			/* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showVetList] produces [java.lang.NullPointerException] */
			vetController.showVetList(-255, null);
		} finally {
			mockedConstruction.close();
			mockedStatic.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method showVetList(int, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 */
	@Test
	@DisplayName("showVetList: page = 3 (mutated from positive), model = mock()")
	public void testShowVetList() {
		Page pageMock = mock(Page.class);
		List list = emptyList();
		(when(pageMock.toList())).thenReturn(list);
		List listMock = mock(List.class);
		(when(pageMock.getContent())).thenReturn(listMock);
		(when(pageMock.getTotalPages())).thenReturn(0);
		(when(pageMock.getTotalElements())).thenReturn(0L);
		(when(vetRepositoryMock.findAll(any()))).thenReturn(pageMock);
		Model modelMock = mock(Model.class);
		Model modelMock1 = mock(Model.class);
		(when(modelMock.addAttribute(any(), any()))).thenReturn(modelMock1);

		String actual = vetController.showVetList(3, modelMock);

		String expected = "vets/vetList";

		assertEquals(expected, actual);
	}
	///endregion

	///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method showVetList(int, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 */
	@Test
	@DisplayName("showVetList: page = -16385 (mutated from -1), model = mock() -> throw IllegalArgumentException")
	public void testShowVetListThrowsIAE() {
		Model modelMock = mock(Model.class);

		assertThrows(IllegalArgumentException.class, () -> vetController.showVetList(-16385, modelMock));
	}
	///endregion

	///region FUZZER: ERROR SUITE for method showVetList(int, org.springframework.ui.Model)

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showVetList(int, Model)}
	 */
	@Test
	@DisplayName("showVetList: page = 2147467263 (mutated from -16385), model = mock() -> throw NullPointerException")
	public void testShowVetListThrowsNPE() {
		Page pageMock = mock(Page.class);
		List listMock = mock(List.class);
		(when(listMock.toArray())).thenReturn(((Object[]) null));
		(when(pageMock.toList())).thenReturn(listMock);
		(when(vetRepositoryMock.findAll(any()))).thenReturn(pageMock);
		Model modelMock = mock(Model.class);

        /* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showVetList] produces [java.lang.NullPointerException]
            java.base/java.util.ArrayList.addAll(ArrayList.java:672)
            org.springframework.samples.petclinic.vet.VetController.showVetList(VetController.java:50) */
		vetController.showVetList(2147467263, modelMock);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.vet.VetController.showResourcesVetList

	///region SYMBOLIC EXECUTION: ERROR SUITE for method showResourcesVetList()

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showResourcesVetList()}
	 * @utbot.invokes {@link List#addAll(Collection)}
	 * @utbot.throwsException {@link NullPointerException} in: vets.getVetList().addAll(this.vetRepository.findAll());
	 */
	@Test
	@DisplayName("showResourcesVetList: vets.getVetList().addAll(this.vetRepository.findAll()) : True -> ThrowNullPointerException")
	public void testShowResourcesVetList_ThrowNullPointerException() {
		MockedConstruction mockedConstruction = null;
		try {
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(null));
			(when(vetRepositoryMock.findAll())).thenReturn(((Collection) null));

            /* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showResourcesVetList] produces [java.lang.NullPointerException]
                org.springframework.samples.petclinic.vet.VetController.showResourcesVetList(VetController.java:74) */
			vetController.showResourcesVetList();
		} finally {
			mockedConstruction.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showResourcesVetList()}
	 * @utbot.invokes {@link List#addAll(Collection)}
	 * @utbot.returnsFrom {@code return vets;}
	 * @utbot.throwsException {@link NullPointerException} in: return vets;
	 */
	@Test
	@DisplayName("showResourcesVetList: return vets -> ThrowNullPointerException")
	public void testShowResourcesVetList_ThrowNullPointerException_1() {
		MockedConstruction mockedConstruction = null;
		try {
			ArrayList arrayList = new ArrayList();
			arrayList.add(null);
			arrayList.add(null);
			arrayList.add(null);
			mockedConstruction = mockConstruction(Vets.class, (Vets vetsMock, Context context) -> (when(vetsMock.getVetList())).thenReturn(arrayList));
			Collection collectionMock = mock(Collection.class);
			(when(collectionMock.size())).thenReturn(0, 0);
			(when(collectionMock.toArray())).thenReturn(((Object[]) null));
			(when(vetRepositoryMock.findAll())).thenReturn(collectionMock);

			/* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showResourcesVetList] produces [java.lang.NullPointerException] */
			vetController.showResourcesVetList();
		} finally {
			mockedConstruction.close();
		}
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method showResourcesVetList()

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showResourcesVetList()}
	 */
	@Test
	@DisplayName("showResourcesVetList: ")
	public void testShowResourcesVetList() throws Exception {
		Collection collection = emptyList();
		(when(vetRepositoryMock.findAll())).thenReturn(collection);

		Vets actual = vetController.showResourcesVetList();

		Vets expected = ((Vets) createInstance("org.springframework.samples.petclinic.vet.Vets"));
		ArrayList vets = new ArrayList();
		setField(expected, "org.springframework.samples.petclinic.vet.Vets", "vets", vets);

		List expectedVets = ((List) getFieldValue(expected, "org.springframework.samples.petclinic.vet.Vets", "vets"));
		List actualVets = ((List) getFieldValue(actual, "org.springframework.samples.petclinic.vet.Vets", "vets"));
		assertTrue(deepEquals(expectedVets, actualVets));

	}
	///endregion

	///region FUZZER: ERROR SUITE for method showResourcesVetList()

	/**
	 * @utbot.classUnderTest {@link VetController}
	 * @utbot.methodUnderTest {@link VetController#showResourcesVetList()}
	 */
	@Test
	@DisplayName("showResourcesVetList:  -> throw NullPointerException")
	public void testShowResourcesVetListThrowsNPE() {
		Collection collectionMock = mock(Collection.class);
		(when(collectionMock.toArray())).thenReturn(((Object[]) null));
		(when(vetRepositoryMock.findAll())).thenReturn(collectionMock);

        /* This test fails because method [org.springframework.samples.petclinic.vet.VetController.showResourcesVetList] produces [java.lang.NullPointerException]
            java.base/java.util.ArrayList.addAll(ArrayList.java:672)
            org.springframework.samples.petclinic.vet.VetController.showResourcesVetList(VetController.java:74) */
		vetController.showResourcesVetList();
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
