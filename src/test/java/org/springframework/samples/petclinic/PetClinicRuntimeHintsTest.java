package org.springframework.samples.petclinic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.ResourceHints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.SerializationHints;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class PetClinicRuntimeHintsTest {
	///region Test suites for executable org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method registerHints(org.springframework.aot.hint.RuntimeHints, java.lang.ClassLoader)

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.invokes {@link RuntimeHints#resources()}
	 * @utbot.invokes {@link ResourceHints#registerPattern(String)}
	 * @utbot.invokes {@link RuntimeHints#resources()}
	 * @utbot.invokes {@link ResourceHints#registerPattern(String)}
	 * @utbot.invokes {@link RuntimeHints#resources()}
	 * @utbot.invokes {@link ResourceHints#registerPattern(String)}
	 * @utbot.invokes {@link RuntimeHints#serialization()}
	 * @utbot.invokes {@link SerializationHints#registerType(Class)}
	 * @utbot.invokes {@link RuntimeHints#serialization()}
	 * @utbot.invokes {@link SerializationHints#registerType(Class)}
	 * @utbot.invokes {@link RuntimeHints#serialization()}
	 * @utbot.invokes {@link SerializationHints#registerType(Class)}
	 */
	@Test
	@DisplayName("registerHints: RuntimeHintsResources -> SerializationHintsRegisterType")
	public void testRegisterHints_SerializationHintsRegisterType() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null));
		ResourceHints resourceHintsMock1 = mock(ResourceHints.class);
		(when(resourceHintsMock1.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null), ((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, resourceHintsMock1, resourceHintsMock1);
		SerializationHints serializationHintsMock = mock(SerializationHints.class);
		(when(serializationHintsMock.registerType(any(Class.class)))).thenReturn(((SerializationHints) null), ((SerializationHints) null), ((SerializationHints) null));
		(when(hintsMock.serialization())).thenReturn(serializationHintsMock, serializationHintsMock, serializationHintsMock);

		petClinicRuntimeHints.registerHints(hintsMock, null);
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method registerHints(org.springframework.aot.hint.RuntimeHints, java.lang.ClassLoader)

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.resources().registerPattern("db/*");
	 */
	@Test
	@DisplayName("registerHints: hints.resources().registerPattern(\"db/*\") : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:29) */
		petClinicRuntimeHints.registerHints(null, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.resources().registerPattern("db/*");
	 */
	@Test
	@DisplayName("registerHints: hints.resources().registerPattern(\"db/*\") : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_1() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		(when(hintsMock.resources())).thenReturn(((ResourceHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:29) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.resources().registerPattern("messages/*");
	 */
	@Test
	@DisplayName("registerHints: hints.resources().registerPattern(\"messages/*\") : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_3() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, ((ResourceHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:30) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.resources().registerPattern("mysql-default-conf");
	 */
	@Test
	@DisplayName("registerHints: hints.resources().registerPattern(\"mysql-default-conf\") : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_2() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null), ((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, resourceHintsMock, ((ResourceHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:31) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.serialization().registerType(BaseEntity.class);
	 */
	@Test
	@DisplayName("registerHints: hints.serialization().registerType(BaseEntity.class) : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_4() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null), ((ResourceHints) null), ((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, resourceHintsMock, resourceHintsMock);
		(when(hintsMock.serialization())).thenReturn(((SerializationHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:32) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.serialization().registerType(Person.class);
	 */
	@Test
	@DisplayName("registerHints: hints.serialization().registerType(Person.class) : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_5() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null));
		ResourceHints resourceHintsMock1 = mock(ResourceHints.class);
		(when(resourceHintsMock1.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null), ((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, resourceHintsMock1, resourceHintsMock1);
		SerializationHints serializationHintsMock = mock(SerializationHints.class);
		(when(serializationHintsMock.registerType(any(Class.class)))).thenReturn(((SerializationHints) null));
		(when(hintsMock.serialization())).thenReturn(serializationHintsMock, ((SerializationHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:33) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetClinicRuntimeHints}
	 * @utbot.methodUnderTest {@link PetClinicRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 * @utbot.invokes {@link RuntimeHints#serialization()}
	 * @utbot.invokes {@link SerializationHints#registerType(Class)}
	 * @utbot.throwsException {@link NullPointerException} in: hints.serialization().registerType(Vet.class);
	 */
	@Test
	@DisplayName("registerHints: hints.serialization().registerType(Vet.class) : True -> ThrowNullPointerException")
	public void testRegisterHints_ThrowNullPointerException_6() {
		PetClinicRuntimeHints petClinicRuntimeHints = new PetClinicRuntimeHints();
		RuntimeHints hintsMock = mock(RuntimeHints.class);
		ResourceHints resourceHintsMock = mock(ResourceHints.class);
		(when(resourceHintsMock.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null));
		ResourceHints resourceHintsMock1 = mock(ResourceHints.class);
		(when(resourceHintsMock1.registerPattern(any(String.class)))).thenReturn(((ResourceHints) null), ((ResourceHints) null));
		(when(hintsMock.resources())).thenReturn(resourceHintsMock, resourceHintsMock1, resourceHintsMock1);
		SerializationHints serializationHintsMock = mock(SerializationHints.class);
		(when(serializationHintsMock.registerType(any(Class.class)))).thenReturn(((SerializationHints) null), ((SerializationHints) null));
		(when(hintsMock.serialization())).thenReturn(serializationHintsMock, serializationHintsMock, ((SerializationHints) null));

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.PetClinicRuntimeHints.registerHints(PetClinicRuntimeHints.java:34) */
		petClinicRuntimeHints.registerHints(hintsMock, null);
	}
	///endregion

	///endregion
}
