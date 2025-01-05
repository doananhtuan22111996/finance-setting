package com.feature.buildSrc

object Configs {

    object BuildModule {
        const val FEATURE_PRESENTATION = ":feature:presentation"
        const val FEATURE_BUSINESS = ":feature:business"
        const val FEATURE_API = ":featureApi"
    }

    object Profile {
        const val PRESENTATION_NAMESPACE = "vn.finance.setting.presentation"
        const val BUSINESS_NAMESPACE = "vn.finance.setting.business"
        const val API_NAMESPACE = "vn.finance.setting.api"
    }

    object Demo {
        const val NAMESPACE = "vn.finance.demo"
        const val APPLICATION_ID = "vn.finance.demo"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
    }

    object Artifact {
        const val GROUP_ID = "vn.finance.libs"
        const val ARTIFACT_PRESENTATION_ID = "feature-setting-presentation"
        const val ARTIFACT_BUSINESS_ID = "feature-setting-business"
        const val ARTIFACT_API_ID = "feature-setting-api"
        const val VERSION = "1.0.1"
    }
}
