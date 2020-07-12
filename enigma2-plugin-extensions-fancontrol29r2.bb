SUMMARY = "Temperature dependent fan control"
DESCRIPTION = "Temperature dependent fan control"
MAINTAINER = "Dreambox Developers"
require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "2.9r2+git${SRCPV}"
PKGV = "2.9r2+git${GITPKGV}"

SRC_URI = "git://github.com/jack2015/fancontrol2.git"
SRCREV = "${AUTOREV}"
FILES_${PN} = "${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
    python -O -m compileall ${S}
}

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
    cp -r --preserve=mode,links ${S}/FanControl2 ${D}${libdir}/enigma2/python/Plugins/Extensions/
    chmod -R a+rX ${D}${libdir}/enigma2/
    find ${D}/ -name '*.pyc' -exec rm {} \;
    find ${D}/ -name '*.po' -exec rm {} \;
    find ${D}/ -name '*.py' -exec rm {} \;
}
