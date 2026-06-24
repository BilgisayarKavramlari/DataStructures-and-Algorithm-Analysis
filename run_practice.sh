#!/usr/bin/env bash
set -euo pipefail
if [ "$#" -ne 1 ]; then
  echo "Usage: bash run_practice.sh XX" >&2
  exit 1
fi
number="$1"
folder=$(find . -maxdepth 1 -type d -name "practice-${number}-*" | sort | head -n 1)
if [ -z "$folder" ]; then
  echo "No practice folder found for number $number" >&2
  exit 1
fi
(cd "$folder" && javac *.java && java Main)
