package com.safecharge.retail.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 3/21/2017
 */
@Retention(RetentionPolicy.RUNTIME) @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE }) public @interface ValidChecksum {
    Constants.ChecksumOrderMapping orderMappingName();
}
