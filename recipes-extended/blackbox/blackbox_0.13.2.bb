SUMMARY = "A beautiful GTK 4 terminal"
HOMEPAGE = "https://gitlab.gnome.org/raggesilver/blackbox"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

DEPENDS = " \
    appstream-glib-native \
    desktop-file-utils-native \
    graphene \
    gtk4 \
    json-glib \
    libadwaita \
    libgee \
    libpcre2 \
    librsvg \
    libxml2 \
    libmarble \
    pango \
    vte \
"

inherit meson gobject-introspection gettext pkgconfig vala features_check

REQUIRED_DISTRO_FEATURES = "opengl"

SRC_URI = "git://gitlab.gnome.org/raggesilver/blackbox.git;protocol=https;branch=main"
SRCREV = "401e22fe9b74e61a06c5ad7ae9c7dd148e0f0a98"
S = "${WORKDIR}/git"

GIR_MESON_OPTION = ''

FILES:${PN} += "${datadir}"
