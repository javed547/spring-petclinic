package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.deepEquals;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class VetsTest {
	@InjectMocks
	private Vets vets;

	@Spy
	private ArrayList arrayListSpy;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.vet.Vets.getVetList

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getVetList()

	/**
	 * @utbot.classUnderTest {@link Vets}
	 * @utbot.methodUnderTest {@link Vets#getVetList()}
	 * @utbot.executesCondition {@code (vets == null): True}
	 * @utbot.returnsFrom {@code return vets;}
	 */
	@Test
	@DisplayName("getVetList: vets == null : True -> return vets")
	public void testGetVetList_VetsEqualsNull() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		setField(vets, "org.springframework.samples.petclinic.vet.Vets", "vets", null);

		ArrayList actual = ((ArrayList) vets.getVetList());

		Assertions.assertTrue(deepEquals(arrayListSpy, actual));
	}

	/**
	 * @utbot.classUnderTest {@link Vets}
	 * @utbot.methodUnderTest {@link Vets#getVetList()}
	 * @utbot.executesCondition {@code (vets == null): False}
	 * @utbot.returnsFrom {@code return vets;}
	 */
	@Test
	@DisplayName("getVetList: vets == null : False -> return vets")
	public void testGetVetList_VetsNotEqualsNull() {
		ArrayList actual = ((ArrayList) vets.getVetList());

		Assertions.assertTrue(deepEquals(arrayListSpy, actual));
	}
	///endregion

	///endregion


	@BeforeEach
	public void setUp() {
		mockitoCloseable = openMocks(this);
	}

	@AfterEach
	public void tearDown() throws Exception {
		arrayListSpy.clear();
		mockitoCloseable.close();
	}

}
