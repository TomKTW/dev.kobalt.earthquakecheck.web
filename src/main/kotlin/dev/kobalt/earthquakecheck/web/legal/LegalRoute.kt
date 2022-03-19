/*
 * dev.kobalt.earthquakecheck
 * Copyright (C) 2022 Tom.K
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.kobalt.earthquakecheck.web.legal

import dev.kobalt.earthquakecheck.web.extension.pageArticle
import dev.kobalt.earthquakecheck.web.extension.pageLink
import dev.kobalt.earthquakecheck.web.extension.respondHtmlContent
import dev.kobalt.earthquakecheck.web.legal.program.legalProgramRoute
import dev.kobalt.earthquakecheck.web.legal.server.legalServerRoute
import io.ktor.application.*
import io.ktor.routing.*

fun Route.legalRoute() {
    route(LegalRepository.pageRoute) {
        get {
            call.respondHtmlContent(
                title = LegalRepository.pageTitle,
                description = LegalRepository.pageSubtitle
            ) {
                pageArticle(
                    LegalRepository.pageTitle,
                    LegalRepository.pageSubtitle
                ) {
                    LegalRepository.pageLinks.forEach {
                        pageLink(it.second, it.third, it.first)
                    }
                }
            }
        }
        legalProgramRoute()
        legalServerRoute()
    }
}
