package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

public final class PetClinicApplicationTest {
	///region Test suites for executable org.springframework.samples.petclinic.PetClinicApplication.main

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method main([Ljava.lang.String;)

	/**
	 * @utbot.classUnderTest {@link PetClinicApplication}
	 * @utbot.methodUnderTest {@link PetClinicApplication#main(String[])}
	 * @utbot.invokes {@link SpringApplication#run(Class, String[])}
	 */
	@Test
	@DisplayName("main: -> SpringApplicationRun")
	public void testMain_SpringApplicationRun() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(SpringApplication.class);
			(mockedStatic.when(() -> SpringApplication.run(any(Class.class), any(String[].class)))).thenReturn(((ConfigurableApplicationContext) null));

			PetClinicApplication.main(null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region FUZZER: SECURITY for method main([Ljava.lang.String;)

	/**
	 * @utbot.classUnderTest {@link PetClinicApplication}
	 * @utbot.methodUnderTest {@link PetClinicApplication#main(String[])}
	 */
	@Test
	@DisplayName("main: arg_0 = String[3]")
	@Disabled(value = "Disabled due to sandbox")
	public void testMainWithNonEmptyObjectArray() {
		String[] args = {"XZ", "\n\t\r", "-3"};

        /* This test fails because method [org.springframework.samples.petclinic.PetClinicApplication.main] produces [java.security.AccessControlException: access denied ("java.util.PropertyPermission" "java.awt.headless" "read")]
            java.base/java.security.AccessControlContext.checkPermission(AccessControlContext.java:485)
            java.base/java.security.AccessController.checkPermission(AccessController.java:1068)
            java.base/java.lang.SecurityManager.checkPermission(SecurityManager.java:416)
            java.base/java.lang.SecurityManager.checkPropertyAccess(SecurityManager.java:1160)
            java.base/java.lang.System.getProperty(System.java:951)
            org.springframework.boot.SpringApplication.configureHeadlessProperty(SpringApplication.java:444)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:308)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:1361)
            org.springframework.boot.SpringApplication.run(SpringApplication.java:1350)
            org.springframework.samples.petclinic.PetClinicApplication.main(PetClinicApplication.java:34) */
	}
	///endregion

	///region FUZZER: TIMEOUTS for method main([Ljava.lang.String;)

	/**
	 * @utbot.classUnderTest {@link PetClinicApplication}
	 * @utbot.methodUnderTest {@link PetClinicApplication#main(String[])}
	 */
	@Test
	@DisplayName("main: arg_0 = String[3]")
	@Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
	public void testMainWithNonEmptyObjectArray1() {
		String[] args = {"\n\t\r", "XZ", "-3"};

        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
		assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> PetClinicApplication.main(args));
	}
	///endregion

	///endregion
}
