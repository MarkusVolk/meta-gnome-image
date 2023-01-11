DESCRIPTION = "Gnome image"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image main-user

WGTK_APPS ?= " \
	evince \
	file-roller \
	geary \
	gnome-calculator \
	gnome-calendar \
	gnome-disk-utility \
	gnome-online-accounts \
	gnome-photos \
	gnome-screenshot \
	gnome-shell \	
	gnome-software \
	gnome-system-monitor \
	gnome-terminal \
	gnome-text-editor \
	gsettings-desktop-schemas \
	eog \
	gvfs \
	gvfsd-trash \
	librsvg-gtk \
	nautilus \
	pavucontrol \
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
	xz \
"

WSYSTEM_CONF ?= " \
	ca-certificates \
	glibc-binary-localedata-cs-cz \
	glibc-binary-localedata-de-de \
	glibc-binary-localedata-en-us \
	glibc-binary-localedata-es-es \
	glibc-binary-localedata-fr-fr \
	glibc-binary-localedata-pl-pl \
	glibc-binary-localedata-ru-ru \
	glibc-charmap-utf-8 \
	gstreamer1.0-meta-base \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-python \
	gstreamer1.0-vaapi \
	linux-firmware \
	localedef \
	nfs-export-public \
	packagegroup-fonts-truetype \
	pulseaudio-user-service \
	resize-helper \
	shared-mime-info \
	shared-mime-info-data \
	steam-udev-rules \
	system-config \
	tzdata \
	tzdata-europe \
	udev-rules-udisks-hide-bootpart \
	wireless-regdb-static \
	xdg-user-dirs \
	xdg-desktop-portal \
	xdg-desktop-portal-gnome \
	xkeyboard-config \
	xorg-minimal-fonts \
	xwayland \	
"
	
WSERVICES ?= " \
	autofs \
	cifs-utils \
	fuse3 \
	fuse3-utils \
	networkmanager \
	networkmanager-wifi \
	nfs-utils \
	nfs-utils-client \
	ntpdate \
	pipewire \
	rpcbind \
	samba \
"

WCOMMERCIAL ?= " \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-ugly \
	ffmpeg \
"

IMAGE_INSTALL += " \
	${WGTK_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WSERVICES} \
	${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', '${WCOMMERCIAL}', '', d)} \
"
