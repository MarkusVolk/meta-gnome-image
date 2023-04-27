DESCRIPTION = "Gnome image"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image main-user

WGTK_APPS ?= " \
	blackbox \
	evince \
	file-roller \
	gdm \
	gnome-calculator \
	gnome-calendar \
	gnome-disk-utility \
	gnome-keyring \
	gnome-menus \
	gnome-online-accounts \
	gnome-remote-desktop \
	gnome-shell \	
	gnome-software \
	gnome-system-monitor \
	gnome-text-editor \
	gsettings-desktop-schemas \
	gparted \
	eog \
	gvfs \
	gvfsd-trash \
	librsvg-gtk \
	nautilus \
	nwg-look \
"

WCONSOLE_TOOLS ?= " \
	bash \
	bzip2 \
	coreutils \
	coreutils-stdbuf \
	curl \
	dosfstools \
	e2fsprogs \
	findutils \
	flatpak \
	gawk \
	git \
	grep \
	gzip \
	htop \
	imagemagick \
	iputils \
	less \
	libusb1 \
	nano \
	procps \
	psmisc \
	pv \
	rsync \
	sed \
	shadow \
	sudo \
	tar \
	usbutils \
	util-linux \
	util-linux-agetty \
	util-linux-fstrim \
	which \
	xprop \
	xz \
"

WSYSTEM_CONF ?= " \
	adw-gtk3 \
	ca-certificates \
	capitaine-cursors \
	cups-filters \
	cups-pk-helper \
	exfatprogs \
	gstreamer1.0-meta-base \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-python \
	gstreamer1.0-vaapi \
	gtk4-printbackend-cups \
	gtk4-printbackend-file \
	libcanberra-pulse \
	linux-firmware \
	nfs-export-public \
	packagegroup-fonts-truetype \
	pulseaudio-user-service \
	resize-helper \
	shared-mime-info \
	shared-mime-info-data \
	sound-theme-freedesktop \
	steam-udev-rules \
	system-config \
	systemd-extra-utils \
	tela-circle-icon-theme \
	tzdata \
	tzdata-europe \
	udev-rules-udisks-hide-bootpart \
	webp-pixbuf-loader \
	wireless-regdb-static \
	xdg-desktop-portal \
	xdg-user-dirs \
	xkeyboard-config \
	xorg-minimal-fonts \
	xwayland \	
"

WSERVICES ?= " \
	autofs \
	avahi-utils \
	cifs-utils \
	cups \
	cups-lib \
	cups-libimage \
	fuse3 \
	fuse3-utils \
	geoclue \
	libavahi-libevent \
	libavahi-common \
	libavahi-core \
	libavahi-client \
	libavahi-glib \
	libavahi-gobject \
	networkmanager \
	networkmanager-wifi \
	nfs-utils \
	nfs-utils-client \
	pipewire \
	rpcbind \
	rtkit \
	samba \
	upower \
"

WCOMMERCIAL ?= " \
	gstreamer1.0-libav \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-ugly \
	ffmpeg \
"

WGLIBC ?= " \
	glibc-binary-localedata-cs-cz \
	glibc-binary-localedata-de-de \
	glibc-binary-localedata-en-us \
	glibc-binary-localedata-es-es \
	glibc-binary-localedata-fr-fr \
	glibc-binary-localedata-pl-pl \
	glibc-binary-localedata-ru-ru \
	glibc-charmap-utf-8 \
	localedef \
"

IMAGE_INSTALL += " \
	${WGTK_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WSERVICES} \
	${@bb.utils.contains('TCLIBC', 'glibc', '${WGLIBC}', '', d)} \
	${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', '${WCOMMERCIAL}', '', d)} \
"
