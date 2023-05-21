DESCRIPTION = "Gnome image"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image main-user

require recipes-core/images/image.inc

WWINDOW_MANAGER ?= "gnome-shell"

WGUI_APPS:append = " \
	blackbox \
	gdm \
	gnome-menus \
	gnome-remote-desktop \
	gparted \
"

WSERVICES:append = " \
	networkmanager \
	networkmanager-wifi \
"
