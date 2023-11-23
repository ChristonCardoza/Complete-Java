Build Instructions
------------------

# Build Requirements

All platforms:

* Mercurial 2.8
* CMake 2.8
* rsync

## Linux

* GCC 4.7 (See instructions below)

Instructions for installing GCC 4.7 on a CentOS system (from the Netwitness wiki):

	Download the devtoolset 1.1 repository definition file
	Name this file something like devtoolset.repo, make sure it ends with .repo
	Copy this file to /etc/yum.repos.d
	yum install devtoolset-1.1
	When you want to use gcc 4.7.2, source the file /opt/centos/devtoolset-1.1/enable to switch paths to the new compiler.

## Darwin

* Clang/XCode 5.0

## Windows

* CMake 2.8.12 or later (for Visual Studio 2013 Generator)
* Visual Studio 2013

# Build Instructions

## Check out the source code

If you are reading this you probably already have.

	prompt$ hg clone https://mixmaster.netwitness.local/protobufs/

## Create a build directory (typically NOT in your source tree)

	prompt$ mkdir -p path-to-my-build-tree

## Run CMake

## Linux/Darwin

	prompt$ cd path-to-my-build-tree
	prompt$ cmake -G "Unix Makefiles" path-to-protobufs/cpp

This will take some time the first time you run it, as it will rsync a few libraries and packages from Ironhide.

### XCode

Create a directory that is not the same as your build directory for makefiles, e.g., `path-to-my-xcode-build-tree`

	prompt$ cd path-to-my-xcode-build-tree
	prompt$ cmake -G Xcode path-to-protobufs/cpp

An XCode project will be created in your build tree, which you can then open via the `open` command or via the Finder.

## Windows

	prompt$ cd path-to-my-build-tree
	prompt$ cmake -G "Visual Studio 12 Win64" path-to-protobufs/cpp

## Build the source code

### Linux/Darwin: Run Make

	prompt$ make	

## Windows

Open the protobufs.sln file in Visual Studio 2013 and build the solutions.
