package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public final class PetValidatorTest {
	///region Test suites for executable org.springframework.samples.petclinic.owner.PetValidator.validate

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method validate(java.lang.Object, org.springframework.validation.Errors)

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (pet.isNew()): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() == null): False}
	 */
	@Test
	@DisplayName("validate: pet.isNew() : False -> pet.getBirthDate() == null : False")
	public void testValidate_PetGetBirthDateNotEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(false);
			LocalDate localDateMock = mock(LocalDate.class);
			(when((((Pet) objMock)).getBirthDate())).thenReturn(localDateMock);
			Errors errorsMock = mock(Errors.class);
			(((Errors) (doNothing()).when(errorsMock))).rejectValue(any(), any(), any());

			petValidator.validate(objMock, errorsMock);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (pet.isNew()): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() == null): True}
	 */
	@Test
	@DisplayName("validate: pet.isNew() : False -> pet.getBirthDate() == null : True")
	public void testValidate_PetGetBirthDateEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(false);
			(when((((Pet) objMock)).getBirthDate())).thenReturn(((LocalDate) null));
			Errors errorsMock = mock(Errors.class);
			(((Errors) (doNothing()).when(errorsMock))).rejectValue(any(), any(), any());

			petValidator.validate(objMock, errorsMock);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (pet.isNew()): True}
	 * @utbot.executesCondition {@code (pet.getType() == null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() == null): False}
	 */
	@Test
	@DisplayName("validate: pet.isNew() : True -> pet.getType() == null : False")
	public void testValidate_PetGetTypeNotEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(true);
			PetType petTypeMock = mock(PetType.class);
			(when((((Pet) objMock)).getType())).thenReturn(petTypeMock);
			LocalDate localDateMock = mock(LocalDate.class);
			(when((((Pet) objMock)).getBirthDate())).thenReturn(localDateMock);
			Errors errorsMock = mock(Errors.class);
			(((Errors) (doNothing()).when(errorsMock))).rejectValue(any(), any(), any());

			petValidator.validate(objMock, errorsMock);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (pet.isNew()): True}
	 * @utbot.executesCondition {@code (pet.getType() == null): True}
	 * @utbot.executesCondition {@code (pet.getBirthDate() == null): True}
	 * @utbot.invokes {@link Errors#rejectValue(String, String, String)}
	 */
	@Test
	@DisplayName("validate: pet.getType() == null : True -> ErrorsRejectValue")
	public void testValidate_PetGetTypeEqualsNull() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(true);
			(when((((Pet) objMock)).getType())).thenReturn(((PetType) null));
			(when((((Pet) objMock)).getBirthDate())).thenReturn(((LocalDate) null));
			Errors errorsMock = mock(Errors.class);
			(((Errors) (doNothing()).when(errorsMock))).rejectValue(any(), any(), any());

			petValidator.validate(objMock, errorsMock);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///region SYMBOLIC EXECUTION: ERROR SUITE for method validate(java.lang.Object, org.springframework.validation.Errors)

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.throwsException {@link ClassCastException} in: Pet pet = (Pet) obj;
	 */
	@Test
	@DisplayName("validate: pet = (Pet) obj : True -> ThrowClassCastException")
	public void testValidate_ThrowClassCastException() {
		PetValidator petValidator = new PetValidator();
		byte[] obj = {};

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.validate] produces [java.lang.ClassCastException: class [B cannot be cast to class org.springframework.samples.petclinic.owner.Pet ([B is in module java.base of loader 'bootstrap'; org.springframework.samples.petclinic.owner.Pet is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @2e38c2a)]
            org.springframework.samples.petclinic.owner.PetValidator.validate(PetValidator.java:38) */
		petValidator.validate(obj, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.throwsException {@link NullPointerException} in: String name = pet.getName();
	 */
	@Test
	@DisplayName("validate: name = pet.getName() : True -> ThrowNullPointerException")
	public void testValidate_ThrowNullPointerException() {
		PetValidator petValidator = new PetValidator();

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.validate] produces [java.lang.NullPointerException]
            org.springframework.samples.petclinic.owner.PetValidator.validate(PetValidator.java:39) */
		petValidator.validate(null, null);
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (!StringUtils.hasText(name)): True}
	 * @utbot.invokes {@link Errors#rejectValue(String, String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: errors.rejectValue("name", REQUIRED, REQUIRED);
	 */
	@Test
	@DisplayName("validate: errors.rejectValue(\"name\", REQUIRED, REQUIRED) : True -> ThrowNullPointerException")
	public void testValidate_ThrowNullPointerException_1() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(false);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.validate] produces [java.lang.NullPointerException] */
			petValidator.validate(objMock, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (!StringUtils.hasText(name)): False}
	 * @utbot.executesCondition {@code (pet.isNew()): True}
	 * @utbot.executesCondition {@code (pet.getType() == null): True}
	 * @utbot.invokes {@link Errors#rejectValue(String, String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: errors.rejectValue("type", REQUIRED, REQUIRED);
	 */
	@Test
	@DisplayName("validate: errors.rejectValue(\"type\", REQUIRED, REQUIRED) : True -> ThrowNullPointerException")
	public void testValidate_ThrowNullPointerException_2() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(true);
			(when((((Pet) objMock)).getType())).thenReturn(((PetType) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.validate] produces [java.lang.NullPointerException] */
			petValidator.validate(objMock, null);
		} finally {
			mockedStatic.close();
		}
	}

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#validate(Object, Errors)}
	 * @utbot.executesCondition {@code (!StringUtils.hasText(name)): False}
	 * @utbot.executesCondition {@code (pet.isNew()): True}
	 * @utbot.executesCondition {@code (pet.getType() == null): False}
	 * @utbot.executesCondition {@code (pet.getBirthDate() == null): True}
	 * @utbot.invokes {@link Pet#getBirthDate()}
	 * @utbot.invokes {@link Errors#rejectValue(String, String, String)}
	 * @utbot.throwsException {@link NullPointerException} in: errors.rejectValue("birthDate", REQUIRED, REQUIRED);
	 */
	@Test
	@DisplayName("validate: errors.rejectValue(\"birthDate\", REQUIRED, REQUIRED) : True -> ThrowNullPointerException")
	public void testValidate_ThrowNullPointerException_3() {
		MockedStatic mockedStatic = null;
		try {
			mockedStatic = mockStatic(StringUtils.class);
			(mockedStatic.when(() -> StringUtils.hasText(any(String.class)))).thenReturn(true);
			PetValidator petValidator = new PetValidator();
			NamedEntity objMock = mock(NamedEntity.class);
			(when(objMock.getName())).thenReturn(((String) null));
			(when(objMock.isNew())).thenReturn(true);
			PetType petTypeMock = mock(PetType.class);
			(when((((Pet) objMock)).getType())).thenReturn(petTypeMock);
			(when((((Pet) objMock)).getBirthDate())).thenReturn(((LocalDate) null));

			/* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.validate] produces [java.lang.NullPointerException] */
			petValidator.validate(objMock, null);
		} finally {
			mockedStatic.close();
		}
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.PetValidator.supports

	///region SYMBOLIC EXECUTION: ERROR SUITE for method supports(java.lang.Class)

	/**
	 * @utbot.classUnderTest {@link PetValidator}
	 * @utbot.methodUnderTest {@link PetValidator#supports(Class)}
	 * @utbot.invokes {@link Class#isAssignableFrom(Class)}
	 * @utbot.returnsFrom {@code return Pet.class.isAssignableFrom(clazz);}
	 * @utbot.throwsException {@link NullPointerException} in: return Pet.class.isAssignableFrom(clazz);
	 */
	@Test
	@DisplayName("supports: return Pet.class.isAssignableFrom(clazz) -> ThrowNullPointerException")
	public void testSupports_ThrowNullPointerException() {
		PetValidator petValidator = new PetValidator();

        /* This test fails because method [org.springframework.samples.petclinic.owner.PetValidator.supports] produces [java.lang.NullPointerException]
            java.base/java.lang.Class.isAssignableFrom(Native Method)
            org.springframework.samples.petclinic.owner.PetValidator.supports(PetValidator.java:61) */
		petValidator.supports(null);
	}
	///endregion

	///endregion
}
