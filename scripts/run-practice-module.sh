#!/usr/bin/env bash
set -euo pipefail

if [ "$#" -ne 1 ]; then
  echo "Usage: bash scripts/run-practice-module.sh XX" >&2
  exit 1
fi
number="$1"
folder=$(find . -maxdepth 1 -type d -name "practice-module-${number}-*" | sort | head -n 1)
if [ -z "$folder" ]; then
  echo "No practice module found for $number" >&2
  exit 1
fi
class="PracticeModule${number}Demo"
(cd "$folder" && javac *.java && java "$class")
