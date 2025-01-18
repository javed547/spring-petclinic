package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;

import static org.utbot.runtime.utils.java.UtUtils.buildLambda;
import static org.utbot.runtime.utils.java.UtUtils.buildStaticLambda;

public final class CacheConfigurationTest {
	///region Test suites for executable org.springframework.samples.petclinic.system.CacheConfiguration.petclinicCacheConfigurationCustomizer

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method petclinicCacheConfigurationCustomizer()

	/**
	 * @utbot.classUnderTest {@link CacheConfiguration}
	 * @utbot.methodUnderTest {@link CacheConfiguration#petclinicCacheConfigurationCustomizer()}
	 * @utbot.returnsFrom {@code return cm -> cm.createCache("vets", cacheConfiguration());}
	 */
	@Test
	@DisplayName("petclinicCacheConfigurationCustomizer: -> return cm -> cm.createCache(\"vets\", cacheConfiguration())")
	public void testPetclinicCacheConfigurationCustomizer_Return() throws Throwable {
		CacheConfiguration cacheConfiguration = new CacheConfiguration();

		JCacheManagerCustomizer actual = cacheConfiguration.petclinicCacheConfigurationCustomizer();

		JCacheManagerCustomizer expected = ((JCacheManagerCustomizer) buildLambda(JCacheManagerCustomizer.class, CacheConfiguration.class, "lambda$petclinicCacheConfigurationCustomizer$0", cacheConfiguration));

	}
	///endregion

	///region FUZZER: SUCCESSFUL EXECUTIONS for method petclinicCacheConfigurationCustomizer()

	/**
	 * @utbot.classUnderTest {@link CacheConfiguration}
	 * @utbot.methodUnderTest {@link CacheConfiguration#petclinicCacheConfigurationCustomizer()}
	 */
	@Test
	@DisplayName("petclinicCacheConfigurationCustomizer: ")
	public void testPetclinicCacheConfigurationCustomizer() throws Throwable {
		CacheConfiguration cacheConfiguration = new CacheConfiguration();

		JCacheManagerCustomizer actual = cacheConfiguration.petclinicCacheConfigurationCustomizer();

		JCacheManagerCustomizer expected = ((JCacheManagerCustomizer) buildStaticLambda(JCacheManagerCustomizer.class, CacheConfiguration.class, "<FAKE>"));

	}
	///endregion

	///endregion
}
