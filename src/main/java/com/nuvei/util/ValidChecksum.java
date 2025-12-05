/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * An annotation used to indicate that the target should be validated using the given {@link Constants.ChecksumOrderMapping}
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 3/21/2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface ValidChecksum {
    Constants.ChecksumOrderMapping orderMappingName();
}
