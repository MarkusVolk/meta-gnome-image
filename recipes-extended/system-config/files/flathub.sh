#!/bin/sh

if nc -zw1 flathub.org 443; then
    flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo
fi
