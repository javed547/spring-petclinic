package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class BaseEntityTest {
	///region Test suites for executable org.springframework.samples.petclinic.model.BaseEntity.getId

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getId()

	/**
	 * @utbot.classUnderTest {@link BaseEntity}
	 * @utbot.methodUnderTest {@link BaseEntity#getId()}
	 * @utbot.returnsFrom {@code return id;}
	 */
	@Test
	@DisplayName("getId: -> return id")
	public void testGetId_ReturnId() {
		BaseEntity baseEntity = new BaseEntity();
		Integer id = 0;
		baseEntity.setId(id);

		Integer actual = baseEntity.getId();

		assertEquals(id, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.BaseEntity.setId

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setId(java.lang.Integer)

	/**
	 * @utbot.classUnderTest {@link BaseEntity}
	 * @utbot.methodUnderTest {@link BaseEntity#setId(Integer)}
	 */
	@Test
	@DisplayName("setId: ")
	public void testSetId() {
		BaseEntity baseEntity = new BaseEntity();
		Integer id = 0;
		baseEntity.setId(id);

		baseEntity.setId(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.BaseEntity.isNew

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method isNew()

	/**
	 * @utbot.classUnderTest {@link BaseEntity}
	 * @utbot.methodUnderTest {@link BaseEntity#isNew()}
	 * @utbot.returnsFrom {@code return this.id == null;}
	 */
	@Test
	@DisplayName("isNew: return this.id == null : False -> return this.id == null")
	public void testIsNew_ThisIdNotEqualsNull() {
		BaseEntity baseEntity = new BaseEntity();
		Integer id = 0;
		baseEntity.setId(id);

		boolean actual = baseEntity.isNew();

		assertFalse(actual);
	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method isNew()

	/**
	 * @utbot.classUnderTest {@link BaseEntity}
	 * @utbot.methodUnderTest {@link BaseEntity#isNew()}
	 */
	@Test
	@DisplayName("isNew:  -> return true")
	public void testIsNewReturnsTrue() {
		BaseEntity baseEntity = new BaseEntity();

		boolean actual = baseEntity.isNew();

		assertTrue(actual);
	}
	///endregion

	///endregion
}
