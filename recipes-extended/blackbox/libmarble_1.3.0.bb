SUMMARY = "A collection of useful functions and reusable widgets"
HOMEPAGE = "https://gitlab.gnome.org/raggesilver"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

DEPENDS = "glib-2.0 gtk4"

inherit meson gobject-introspection vala pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "opengl"

SRC_URI = "git://gitlab.gnome.org/raggesilver/marble.git;protocol=https;branch=wip/gtk4"
SRCREV = "6dcc6fefa35f0151b0549c01bd774750fe6bdef8"
S = "${WORKDIR}/git"

GIR_MESON_OPTION = ''
