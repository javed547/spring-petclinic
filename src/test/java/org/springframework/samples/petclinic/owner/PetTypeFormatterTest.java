package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;

public final class PetTypeFormatterTest {
	@InjectMocks
	private PetTypeFormatter petTypeFormatter;

	@Mock
	private OwnerRepository ownerRepositoryMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetTypeFormatter.print

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method print(org.springframework.samples.petclinic.owner.PetType, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#print(PetType, Locale)}
	 * @utbot.invokes {@link PetType#getName()}
	 * @utbot.returnsFrom {@code return petType.getName();}
	 */
	@Test
	@DisplayName("print: PetTypeGetName -> return petType.getName()")
	public void testPrint_PetTypeGetName() {
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn(((String) null));

		String actual = petTypeFormatter.print(petTypeMock, ((Locale) null));

		assertNull(actual);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method print(org.springframework.samples.petclinic.owner.PetType, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#print(PetType, Locale)}
	 * @utbot.invokes {@link PetType#getName()}
	 * @utbot.throwsException {@link NullPointerException} in: return petType.getName();
	 */
	@Test
	@DisplayName("print: return petType.getName() : True -> ThrowNullPointerException")
	public void testPrint_ThrowNullPointerException() {
        /* This test fails because method [org.springframework.samples.petclinic.owner.PetTypeFormatter.print] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetTypeFormatter.print(PetTypeFormatter.java:48) */
		petTypeFormatter.print(((PetType) null), ((Locale) null));
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetTypeFormatter.parse

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.invokes {@link OwnerRepository#findPetTypes()}
	 * @utbot.invokes {@link java.util.Collection#iterator()}
	 * @utbot.iterates iterate the loop {@code for(PetType type: findPetTypes)} once
	 */
	@Test
	@DisplayName("parse: OwnerRepositoryFindPetTypes -> return type")
	public void testParse_TypeGetNameEquals() throws Exception {
		ArrayList arrayList = new ArrayList();
		PetType petType = ((PetType) createInstance("org.springframework.samples.petclinic.owner.PetType"));
		String name = "";
		petType.setName(name);
		arrayList.add(petType);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);

		PetType actual = petTypeFormatter.parse(name, ((Locale) null));

		PetType expected = new PetType();
		expected.setName(name);

		String expectedName = expected.getName();
		String actualName = actual.getName();
		assertEquals(expectedName, actualName);

		Integer actualId = actual.getId();
		assertNull(actualId);

	}
	///endregion

	///region SYMBOLIC EXECUTION: CHECKED EXCEPTIONS for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.throwsException {@link ParseException} in: throw new ParseException("type not found: " + text, 0);
	 */
	@Test
	@DisplayName("parse:  -> ThrowParseException")
	public void testParse_ThrowParseException() {
		ArrayList arrayList = new ArrayList();
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);

		assertThrows(ParseException.class, () -> petTypeFormatter.parse(((String) null), ((Locale) null)));
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.iterates iterate the loop {@code for(PetType type: findPetTypes)} once
	 * @utbot.throwsException {@link ParseException} in: throw new ParseException("type not found: " + text, 0);
	 */
	@Test
	@DisplayName("parse:  -> ThrowParseException")
	public void testParse_ThrowParseException_1() throws Exception {
		ArrayList arrayList = new ArrayList();
		PetType petType = ((PetType) createInstance("org.springframework.samples.petclinic.owner.PetType"));
		String name = "";
		petType.setName(name);
		arrayList.add(petType);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);

		assertThrows(ParseException.class, () -> petTypeFormatter.parse(((String) null), ((Locale) null)));
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.iterates iterate the loop {@code for(PetType type: findPetTypes)} once
	 * @utbot.throwsException {@link ClassCastException} in: for(PetType type: findPetTypes)
	 */
	@Test
	@DisplayName("parse: for(PetType type: findPetTypes) -> ThrowClassCastException")
	public void testParse_ThrowClassCastException() throws Exception {
		ArrayList arrayList = new ArrayList();
		Object object = createInstance("java.lang.Object");
		arrayList.add(object);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetTypeFormatter.parse] produces [java.lang.ClassCastException: class java.lang.Object cannot be cast to class org.springframework.samples.petclinic.owner.PetType (java.lang.Object is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.PetType is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @22f7455e)]
            org.springframework.samples.petclinic.owner.PetTypeFormatter.parse(PetTypeFormatter.java:54) */
		petTypeFormatter.parse(((String) null), ((Locale) null));
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.invokes {@link java.util.Collection#iterator()}
	 * @utbot.throwsException {@link NullPointerException} in: for(PetType type: findPetTypes)
	 */
	@Test
	@DisplayName("parse: for(PetType type: findPetTypes) -> ThrowNullPointerException")
	public void testParse_ThrowNullPointerException() throws ParseException {
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(((List) null));

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetTypeFormatter.parse] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetTypeFormatter.parse(PetTypeFormatter.java:54) */
		petTypeFormatter.parse(((String) null), ((Locale) null));
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 * @utbot.iterates iterate the loop {@code for(PetType type: findPetTypes)} once
	 * @utbot.throwsException {@link NullPointerException} when: type.getName().equals(text)
	 */
	@Test
	@DisplayName("parse: type.getName().equals(text) -> ThrowNullPointerException")
	public void testParse_ThrowNullPointerException_1() throws ParseException {
		ArrayList arrayList = new ArrayList();
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.add(null);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetTypeFormatter.parse] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetTypeFormatter.parse(PetTypeFormatter.java:55) */
		petTypeFormatter.parse(((String) null), ((Locale) null));
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '-3', locale = Locale(String, String)")
	public void testParseWithNonEmptyString() throws ParseException {
		LinkedList linkedList = new LinkedList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn("-3");
		linkedList.add(petTypeMock);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(linkedList);
		Locale locale = new Locale("XZ", "abc");

		PetType actual = petTypeFormatter.parse("-3", locale);

		assertSame(petTypeMock, actual);
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '', locale = Locale(String, String)")
	public void testParseWithEmptyString() throws ParseException {
		ArrayList arrayList = new ArrayList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn("\n\t\r");
		arrayList.add(petTypeMock);
		PetType petTypeMock1 = mock(PetType.class);
		(when(petTypeMock1.getName())).thenReturn("");
		arrayList.add(petTypeMock1);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);
		Locale locale = new Locale("XZ", "-3");

		PetType actual = petTypeFormatter.parse("", locale);

		assertSame(petTypeMock1, actual);
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '\n\t\r', locale = Locale(String, String)")
	public void testParseWithBlankString() throws ParseException {
		ArrayList arrayList = new ArrayList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn("#$\\\"'");
		arrayList.add(petTypeMock);
		PetType petTypeMock1 = mock(PetType.class);
		(when(petTypeMock1.getName())).thenReturn("-3");
		arrayList.add(petTypeMock1);
		PetType petTypeMock2 = mock(PetType.class);
		(when(petTypeMock2.getName())).thenReturn("\n\t\r");
		arrayList.add(petTypeMock2);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(arrayList);
		Locale locale = new Locale("\n\t\r", "-3");

		PetType actual = petTypeFormatter.parse("\n\t\r", locale);

		assertSame(petTypeMock2, actual);
	}
	///endregion

	///region FUZZER: CHECKED EXCEPTIONS for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '-\u000B3' (mutated from '-3'), locale = Locale(String, String) -> throw ParseException")
	public void testParseThrowsPEWithNonEmptyString() {
		LinkedList linkedList = new LinkedList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn("-3");
		linkedList.add(petTypeMock);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(linkedList);
		Locale locale = new Locale("XZ", "abc");

		assertThrows(ParseException.class, () -> petTypeFormatter.parse("-\u000B3", locale));
	}

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '#\\\"'', locale = Locale(String, String) -> throw ParseException")
	public void testParseThrowsPEWithNonEmptyString1() {
		LinkedList linkedList = new LinkedList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn("#$\\\"'");
		linkedList.add(petTypeMock);
		PetType petTypeMock1 = mock(PetType.class);
		(when(petTypeMock1.getName())).thenReturn("");
		linkedList.add(petTypeMock1);
		PetType petTypeMock2 = mock(PetType.class);
		(when(petTypeMock2.getName())).thenReturn("\n\t\r");
		linkedList.add(petTypeMock2);
		PetType petTypeMock3 = mock(PetType.class);
		(when(petTypeMock3.getName())).thenReturn("\n\t\r");
		linkedList.add(petTypeMock3);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(linkedList);
		Locale locale = new Locale("XZ", "XZ");

		assertThrows(ParseException.class, () -> petTypeFormatter.parse("#\\\"'", locale));
	}
	///endregion

	///region FUZZER: ERROR SUITE for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '+abc' (mutated from 'abc'), locale = Locale(String) -> throw NullPointerException")
	public void testParseThrowsNPEWithNonEmptyString() throws ParseException {
		LinkedList linkedList = new LinkedList();
		PetType petTypeMock = mock(PetType.class);
		(when(petTypeMock.getName())).thenReturn(((String) null));
		linkedList.add(petTypeMock);
		PetType petTypeMock1 = mock(PetType.class);
		linkedList.add(petTypeMock1);
		PetType petTypeMock2 = mock(PetType.class);
		linkedList.add(petTypeMock2);
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(linkedList);
		Locale locale = new Locale("");

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetTypeFormatter.parse] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetTypeFormatter.parse(PetTypeFormatter.java:55) */
		petTypeFormatter.parse("+abc", locale);
	}
	///endregion

	///region FUZZER: TIMEOUTS for method parse(java.lang.String, java.util.Locale)

	/**
	 * @utbot.classUnderTest {@link PetTypeFormatter}
	 * @utbot.methodUnderTest {@link PetTypeFormatter#parse(String, Locale)}
	 */
	@Test
	@DisplayName("parse: text = '1', locale = Locale(String, String)")
	@Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
	public void testParseWithNonEmptyString1() throws ParseException {
		List list = emptyList();
		(when(ownerRepositoryMock.findPetTypes())).thenReturn(list);
		Locale locale = new Locale("", "");

        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
		assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> petTypeFormatter.parse("1", locale));
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
