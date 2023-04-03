SUMMARY = "Virtual terminal emulator GTK+ widget library"
DESCRIPTION = "VTE provides a virtual terminal widget for GTK applications."
HOMEPAGE = "https://wiki.gnome.org/Apps/Terminal/VTE"
BUGTRACKER = "https://bugzilla.gnome.org/buglist.cgi?product=vte"
LICENSE = "GPL-3.0-only & LGPL-3.0-or-later & MIT"
LICENSE:libvte = "LGPL-3.0-or-later"

LIC_FILES_CHKSUM = " \
    file://COPYING.GPL3;md5=cc702cf3444d1f19680c794cc61948f9 \
    file://COPYING.LGPL3;md5=b52f2d57d10c4f7ee67a7eb9615d5d24 \
    file://COPYING.XTERM;md5=d7fc3a23c16c039afafe2e042030f057 \
"

DEPENDS = "fribidi glib-2.0 gtk+3 libpcre2 libxml2-native gperf-native icu pango zlib"

GNOMEBASEBUILDCLASS = "meson"
GIR_MESON_OPTION = 'gir'
GIDOCGEN_MESON_OPTION = "docs"

inherit gnomebase gi-docgen features_check upstream-version-is-even gobject-introspection vala

# vapigen.m4 is required when vala is not present (but the one from vala should be used normally)
SRC_URI += "file://0001-Add-W_EXITCODE-macro-for-non-glibc-systems.patch"
SRC_URI[archive.sha256sum] = "40fe914d6c70db34176c922725b6c6ea15d5f3cb2a9b44c57e200a5f950a6736"

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"

# Package additional files
FILES:${PN}-dev += "${datadir}/vala/vapi/*"

PACKAGECONFIG:class-target ??= " \
    gnutls \
    ${@bb.utils.contains('GI_DATA_ENABLED', 'True', 'gir vala', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gtk4', '', d)} \
"
PACKAGECONFIG[gtk4] = "-Dgtk4=true,-Dgtk4=false,gtk4"
PACKAGECONFIG[gir] = "-Dgir=true,-Dgir=false"
PACKAGECONFIG[vala] = "-Dvapi=true,-Dvapi=false"
PACKAGECONFIG[gnutls] = "-Dgnutls=true,-Dgnutls=false,gnutls"
PACKAGECONFIG[systemd] = "-D_systemd=true,-D_systemd=false,systemd"

CFLAGS += "-D_GNU_SOURCE"

PACKAGES =+ "libvte ${PN}-prompt"
FILES:libvte = "${libdir}/*.so.* ${libdir}/girepository-1.0/*"
FILES:${PN}-prompt = " \
    ${sysconfdir}/profile.d \
    ${libexecdir}/vte-urlencode-cwd \
"

FILES:${PN}-dev += "${datadir}/glade/"

BBCLASSEXTEND = "native nativesdk"
